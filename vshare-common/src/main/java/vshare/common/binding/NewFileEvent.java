package vshare.common.binding;

import org.springframework.context.ApplicationEvent;

public class NewFileEvent extends ApplicationEvent {
    String name;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public NewFileEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
