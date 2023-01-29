package com.sonder.as1.services;

import com.sonder.as1.entity.PageC;
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

@Service
public class UserService implements EntityService<User> {
    private final UserRepository userRepository;

    @Autowired
    public UserService( UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setLock(Integer id){
        userRepository.setState(0,id);
    }
    public void setUnLock(Integer id){
        userRepository.setState(1,id);
    }
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public PageC<User> getAll(int page, int size) {
        PageC<User> userPageC = new PageC<>();
        Page<User> userPage = userRepository.findAll(PageRequest.of(page - 1, size, Sort.by("id")));
        userPageC.setPage(page);
        userPageC.setSize(size);
        userPageC.setTotalPage(userPage.getTotalPages());
        userPageC.setTs(userPage.stream().toList());
        return userPageC;
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
