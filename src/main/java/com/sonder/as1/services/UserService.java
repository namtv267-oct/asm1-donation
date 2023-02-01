package com.sonder.as1.services;

import com.sonder.as1.dto.ModelDto;
import com.sonder.as1.entity.User;
import com.sonder.as1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements EntityService<User> {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setLock(Integer id) {
        userRepository.setState(0, id);
    }

    public void setUnLock(Integer id) {
        userRepository.setState(1, id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public ModelDto<User> getAll(int page, int size) {
        Page<User> userPage = userRepository.findAll(PageRequest.of(page - 1, size));
        return new ModelDto<User>("Thành công", "Danh sách người dùng", userPage.stream().toList(), page, size, userPage.getTotalPages());
    }

    public ModelDto<User> getAllByUsernameOrPhoneNumber(int page, int size, String data) {
        int offset = page * size;

        StringBuilder stringBuilder = new StringBuilder("%$%");
        stringBuilder.replace(1, 2, data);
        int totalPage = userRepository.findByUsernameOrPhoneNumber(stringBuilder.toString())/size;
        userRepository.findByUsernameOrPhoneNumber(stringBuilder.toString(), size, offset);
        return new ModelDto<>("Thành công"
                , "Danh sách người dùng"
                , userRepository.findByUsernameOrPhoneNumber(stringBuilder.toString(), size, offset), page, size, totalPage);

    }
    @Override
    public void createEntity(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateEntity(User user, Integer id) {
        userRepository.save(user);
    }

    @Override
    public User getById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        userOptional.orElseThrow(() -> new NoSuchElementException("No User exist"));
        return userOptional.get();
    }

    @Override
    public void deleteEntity(Integer id) {
        userRepository.deleteById(id);
    }
}
