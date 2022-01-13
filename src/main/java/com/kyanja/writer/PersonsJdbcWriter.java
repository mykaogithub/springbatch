package com.kyanja.writer;

import com.kyanja.model.Person;
import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class PersonsJdbcWriter implements ItemWriter<Person> {

    final static Logger logger = Logger.getLogger(PersonsJdbcWriter.class);

    private JdbcTemplate jdbcTemplate;

    private static final String REQUEST_INSERT_PERSON =
            "insert into PERSON (id,name,surname,email,gender) values (?,?,?,?,?)";
    private static final String REQUEST_UPDATE_PERSON
            = "update PERSON set name=?,surname=?, email=?, gender=? where id=?";


    public void write(List<? extends Person> items) throws Exception {

        for (Person p : items) {

            final Object object[] = {p.getName(), p.getSurname(), p.getEmail(), p.getGender(), p.getId()};
            //on tente un update
            int nbLigne = jdbcTemplate.update(REQUEST_UPDATE_PERSON, object);

            logger.info("Writing update Person into database*********************************************" );
            logger.info(p.toString());
            logger.info("****************************************************************************");
            //si le nombre de lignes mises a jour vaut 0, on fait un insert
            if (nbLigne == 0) {
                final Object object2[] = {p.getId(), p.getName(), p.getSurname(),p.getEmail(), p.getGender()};
                jdbcTemplate.update(REQUEST_INSERT_PERSON, object2);
                logger.info("Writing  Person into database*********************************************" );
                logger.info(p.toString());
                logger.info("****************************************************************************");
            } else {
            }
        }

    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static String getRequestInsertPerson() {
        return REQUEST_INSERT_PERSON;
    }

    public static String getRequestUpdatePerson() {
        return REQUEST_UPDATE_PERSON;
    }
}
