package com.news.command;

import com.news.exception.DAOException;
import com.news.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class CommendList implements Command{
    @Override
    public boolean execute(HttpServletRequest request) {
        System.out.println("Command List:\n1) create author:\n2) creat news:\n3) Delete author\n4) Delete news\n5)" +
                "read author\n6) read news\n7) update author\n8) update news\n9");
        return true;
    }
}
