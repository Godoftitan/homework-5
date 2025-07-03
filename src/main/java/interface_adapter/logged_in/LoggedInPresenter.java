package interface_adapter.logged_in;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginState;
import use_case.change_password.ChangePasswordOutputBoundary;
import use_case.change_password.ChangePasswordOutputData;

/**
 * The Presenter for the Change Password Use Case.
 */
public class LoggedInPresenter implements ChangePasswordOutputBoundary {

    private final LoggedInViewModel loggedInViewModel;
    private final ViewManagerModel viewManagerModel;

    public LoggedInPresenter(ViewManagerModel viewManagerModel,
                             LoggedInViewModel loggedInViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
    }

    @Override
    public void prepareSuccessView(ChangePasswordOutputData outputData) {
        // TODO update the viewmodel!
        final LoggedInState loggedInState = this.loggedInViewModel.getState();
        loggedInState.setPassword("");
        this.loggedInViewModel.setState(loggedInState);
        this.loggedInViewModel.firePropertyChanged("password");
        this.viewManagerModel.setState(loggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged("password");

    }

    @Override
    public void prepareFailView(String error) {
        // TODO update the viewmodel!
        final LoggedInState loginState = this.loggedInViewModel.getState();
        loginState.setPasswordError(error);
        this.loggedInViewModel.firePropertyChanged();
    }
}
