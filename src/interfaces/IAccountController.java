package interfaces;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ReadingListCollection;
import model.Researcher;
import view.AccountPage;

public interface IAccountController {


    interface CreateNewReadingListListener extends ActionListener {
        void actionPerformed(ActionEvent e);
    }
}
