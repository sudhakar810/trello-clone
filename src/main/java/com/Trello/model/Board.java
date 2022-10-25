
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
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "board_id",
    "board_name",
    "board_lists"
})
@Document(collection = "Boards")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    @JsonProperty("board_id")
    @Id
    private Integer boardId;
    @JsonProperty("board_name")
    private String boardName;
    @JsonProperty("board_lists")
    @Valid
    private List<BoardList> boardLists = null;

}
