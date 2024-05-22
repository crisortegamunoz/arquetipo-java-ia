package com.cristianortega.azure.domain.dto;

import com.cristianortega.azure.domain.dto.action.KeyValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Action {

    public String action;
    public List<KeyValue> data;

}
