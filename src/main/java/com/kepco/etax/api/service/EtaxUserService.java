package com.kepco.etax.api.service;

import com.kepco.etax.api.domain.entity.EtaxUser;
import com.kepco.etax.api.domain.request.login.EtaxUserRequest;
import com.kepco.etax.api.domain.response.EtaxUserResponse;
import com.kepco.etax.api.exception.EtaxUserNotFoundException;
import com.kepco.etax.api.repository.EtaxUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
@CrossOrigin("*")
public class EtaxUserService {
    private EtaxUserRepository userJpaRepo;

    @Transactional
    public Long save(EtaxUserRequest userDto) {
        EtaxUser saved = userJpaRepo.save(userDto.toEntity());
        return saved.getUserId();
    }

    @Transactional(readOnly = true)
    public EtaxUserResponse findById(Long id) {
        EtaxUser user = userJpaRepo.findById(id)
                .orElseThrow(EtaxUserNotFoundException::new);
        return new EtaxUserResponse(user);
    }

    public EtaxUserResponse findByUsername(String username) {
        EtaxUser user = userJpaRepo.findByUsername(username)
            .orElseThrow(EtaxUserNotFoundException::new);
        return new EtaxUserResponse(user);
    }

    @Transactional(readOnly = true)
    public EtaxUserResponse findByEmail(String email) {
        EtaxUser user = userJpaRepo.findByEmail(email)
                .orElseThrow(EtaxUserNotFoundException::new);
        return new EtaxUserResponse(user);
    }

    @Transactional(readOnly = true)
    public List<EtaxUserResponse> findAllUser() {
        return userJpaRepo.findAll()
                .stream()
                .map(EtaxUserResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long update(Long id, EtaxUserRequest userRequestDto) {
        EtaxUser modifiedUser = userJpaRepo
                .findById(id).orElseThrow(EtaxUserNotFoundException::new);
        modifiedUser.updateNickName(userRequestDto.getNickName());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        userJpaRepo.deleteById(id);
    }
}

