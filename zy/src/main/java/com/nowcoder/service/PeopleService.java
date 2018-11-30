package com.nowcoder.service;

import com.nowcoder.dao.PeopleDAO;
import com.nowcoder.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {
    @Autowired
    private PeopleDAO peopleDAO;

    public void addPeople(People people){
        peopleDAO.addPeople(people);
    }
    public List<People> selectByuserName(String userName){
        return peopleDAO.selectByuserName(userName);
    }

}
