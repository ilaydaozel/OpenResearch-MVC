package interfaces;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import store.UserStore;
import view.LoginPage;

public interface IAuthController {
    void setLoginView(LoginPage loginView);
    void setUserStore(UserStore session);
    void addLoginListener(LoginListener listener);
    void isValidUser(String username, String password);

    interface LoginListener extends ActionListener {
        void actionPerformed(ActionEvent e);
    }
}
