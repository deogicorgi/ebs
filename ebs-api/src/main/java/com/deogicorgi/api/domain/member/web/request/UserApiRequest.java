package com.deogicorgi.api.domain.member.web.request;

import com.deogicorgi.api.domain.member.web.controller.MemberController;
import com.deogicorgi.core.web.request.ApiRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Body containing user data
 * used class :
 *
 * @see MemberController
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class UserApiRequest extends ApiRequest {
    private Long userId;
}
