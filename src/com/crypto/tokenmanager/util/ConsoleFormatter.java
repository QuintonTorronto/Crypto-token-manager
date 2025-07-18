package com.crypto.tokenmanager.util;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class ConsoleFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        return record.getMessage() + "\n";
    }

}
