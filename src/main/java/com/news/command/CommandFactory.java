package com.news.command;

import com.news.command.impl.*;

public class CommandFactory {

    private CommandFactory() {
    }

    public static Command getCommend(String command) {
        switch (command) {
            case "Create_Author":
                return new CreateAuthor();
            case "Create_User":
                return new CreatUser();
            case "Create_News":
                return new CreateNews();
            case "Delete_Author":
                return new DeleteAuthor();
            case "Delete_News":
                return new DeleteNews();
            case "ReadA_uthor":
                return new ReadAuthor();
            case "Read_News":
                return new ReadNews();
            case "Update_Author":
                return new UpdateAuthor();
            case "Update_News":
                return new UpdateNews();
            case "Login_":
                return new Login();

            default:
                return new CommendList();
        }
    }

}
