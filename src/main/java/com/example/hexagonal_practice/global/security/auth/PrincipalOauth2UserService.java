package com.example.hexagonal_practice.global.security.auth;

import com.example.hexagonal_practice.account.adapter.out.persistence.UserRepository;
import com.example.hexagonal_practice.account.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        log.info("getAttributes : {}", oAuth2User.getAttributes());

        String provider = userRequest.getClientRegistration().getRegistrationId();
        String providerId = oAuth2User.getAttribute("sub");
        String userId = provider + "_" +providerId;

        Optional<User> optionalUser = userRepository.findByUserId(userId);
        User user;

        if(optionalUser.isEmpty()) {
            user = User.builder()
                    .userId(userId)
                    .username(oAuth2User.getAttribute("name"))
                    .provider(provider)
                    .providerId(providerId)
                    .build();
            userRepository.save(user);
        } else {
            user = optionalUser.get();
        }

        return new CustomUserOauth(user, oAuth2User.getAttributes());
    }
}
