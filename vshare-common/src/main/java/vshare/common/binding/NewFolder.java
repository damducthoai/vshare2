package vshare.common.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class NewFolder {
    private Long parrentId;
    @NotNull
    @NotEmpty
    @NotBlank
    private String name;

    public Long getParrentId() {
        return parrentId;
    }

    public void setParrentId(Long parrentId) {
        this.parrentId = parrentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
