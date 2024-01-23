package com.ecommerce.mb.commerce.utils;

import com.ecommerce.mb.commons.models.enums.CodeEnum;

public interface Messenger {

    String getMessage (CodeEnum code);

    String getMessage(CodeEnum code, Object... args);
}
