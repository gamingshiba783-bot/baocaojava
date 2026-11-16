package com.javaweb.converter;

import com.javaweb.builder.LoanDetailSearchBuilder;
import com.javaweb.utils.MapUtil;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.Map;

public class LoanDetailSearchConverter {
    public LoanDetailSearchBuilder toloandetailsearchbuilder(Map<String, Object> params) {
        LoanDetailSearchBuilder loanDetailSearchBuilder = new LoanDetailSearchBuilder.Builder().setId(MapUtil.getObject(params,"id", Long.class))
                .setActualReturnDate(MapUtil.getObject(params,"actualReturnDate", LocalDate.class))
                .setReturnCondition(MapUtil.getObject(params,"returnCondition",String.class)).build();
        return loanDetailSearchBuilder;
    }
}
