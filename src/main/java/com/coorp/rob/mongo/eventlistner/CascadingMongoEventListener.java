package com.coorp.rob.mongo.eventlistner;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.util.ReflectionUtils;

import com.coorp.rob.annotation.CascadeSave;


public class CascadingMongoEventListener extends AbstractMongoEventListener<Object>{

	@Autowired
	private MongoOperations mongoOperations;
	

//	@Override
//	public void onBeforeConvert(BeforeConvertEvent<Student> event) {
//		Object source = event.getSource();
//		if ((source instanceof Student) && (((Student) source).getEsami() != null)) {
//			List<Exam> esami = ((Student) source).getEsami();
//			for (Exam e : esami) {
//				mongoOperations.save(e);
//			}
//		}
//	}

	@Override
	public void onBeforeConvert(BeforeConvertEvent<Object> event) {
		
		ReflectionUtils.doWithFields(event.getSource().getClass(), new ReflectionUtils.FieldCallback() {

			public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
				ReflectionUtils.makeAccessible(field);

				if (field.isAnnotationPresent(DBRef.class) && field.isAnnotationPresent(CascadeSave.class)) {
					final Object fieldValue = field.get(event.getSource());

					if (fieldValue.getClass().getSimpleName().equals("ArrayList")) {
						for (Object obj : (ArrayList) fieldValue) {
							mongoOperations.save(obj);
						}
					} else {
						mongoOperations.save(fieldValue);
					}
				}
			}
		});
	}
	
}