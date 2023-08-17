package com.example.hexagonal_practice.account.application.service.user;

import com.example.hexagonal_practice.account.adapter.dto.response.UserResponse;
import com.example.hexagonal_practice.account.application.port.in.user.GetMyInfoUseCase;
import com.example.hexagonal_practice.account.application.port.in.user.UserFacadeUseCase;
import com.example.hexagonal_practice.account.domain.User;
import com.example.hexagonal_practice.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class GetMyInfoService implements GetMyInfoUseCase {
    private final UserFacadeUseCase userFacade;

    public UserResponse getMyInfo() {
        User user = userFacade.currentUser();

        return new UserResponse(user);
    }
}
