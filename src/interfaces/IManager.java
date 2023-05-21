package interfaces;

import store.UserStore;

public interface IManager {
    void initialize();
    void onLogin(UserStore session);
    void onLogout(UserStore session);
    void changeHomeContent(String destination);
}
