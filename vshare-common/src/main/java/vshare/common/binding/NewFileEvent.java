package vshare.common.binding;

import org.springframework.context.ApplicationEvent;

public class NewFileEvent extends ApplicationEvent {
    String name;
    long size;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public NewFileEvent(Object source, String name, long size) {
        super(source);
        this.name = name;
        this.size = size;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
