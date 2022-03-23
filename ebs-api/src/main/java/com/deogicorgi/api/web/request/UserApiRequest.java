package com.deogicorgi.api.web.request;

import com.deogicorgi.core.web.request.ApiRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Body containing user data
 * used class :
 *
 * @see com.deogicorgi.api.web.controller.UserController
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class UserApiRequest extends ApiRequest {
    private Long userId;
}
