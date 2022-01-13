package com.kyanja.processor;

import  com.kyanja.model.Person;
import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor  implements ItemProcessor<Person, Person> {

    final static Logger logger = Logger.getLogger(PersonItemProcessor.class);


    public Person process(Person item) throws Exception {

        Person personOutput = null;

        //si la civilite a la valeur M la personne sera ecrite en base sinon on la  rejette
        if ("Male".equals(item.getGender()))
        {
            personOutput = new Person();
            personOutput.setGender(item.getGender());
            personOutput.setId(item.getId());
            personOutput.setName(item.getName());
            personOutput.setSurname(item.getSurname());
            personOutput.setEmail(item.getEmail());

            logger.info("Processing  Person*********************************************" );
            logger.info(item.toString());
            logger.info("****************************************************************");
        }

        return  personOutput;
    }
}
