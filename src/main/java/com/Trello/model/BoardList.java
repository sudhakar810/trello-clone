
package com.Trello.model;

import java.util.List;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "list_id",
    "list_name",
    "items"
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardList {

    @JsonProperty("list_id")
    private Integer listId;
    @JsonProperty("list_name")
    private String listName;
    @JsonProperty("items")
    @Valid
    private List<String> items = null;

}
