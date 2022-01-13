package com.kyanja.processor;

import com.kyanja.model.Record;
import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;

import java.text.MessageFormat;

public class RecordItemProcessor  implements ItemProcessor<Record, Record> {

    final static Logger logger = Logger.getLogger(RecordItemProcessor.class);

    private MessageFormat fmt = new MessageFormat("{0} items processed");

    private int loggingInterval = 2;


    @Override
    public Record process(Record item) throws Exception {
        logger.info("Processing  record*********************************************" );
        logger.info(item.toString());
        logger.info("****************************************************************");
        return item;

    }

    public MessageFormat getFmt() {
        return fmt;
    }

    public void setFmt(MessageFormat fmt) {
        this.fmt = fmt;
    }

    public int getLoggingInterval() {
        return loggingInterval;
    }

    public void setLoggingInterval(int loggingInterval) {
        this.loggingInterval = loggingInterval;
    }
}
