package org.eug.todo.controller.exception;

public final class ControllerException extends Exception {

    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(String message, Exception e) {
        super(message, e);
    }

    public ControllerException(Exception e) {
        super(e);
    }
}