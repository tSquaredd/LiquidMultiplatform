import MaterialComponents
import UIKit
import shared

internal class WelcomeViewController: UIViewController {
    
    let stringResources: WelcomeResourcesImpl = WelcomeResourcesImpl()
    
    private lazy var getStartedButton: MDCButton = {
        ButtonUtils.createPrimaryButton(
            withTitle: stringResources.buttonText.localized(),
            inContainerView: getStartedButtonContainer
        )
    }()
    
    @IBOutlet weak var welcomeLabel: UILabel!
    @IBOutlet weak var getStartedButtonContainer: UIView!
    
    
    override internal func viewDidLoad() {
        super.viewDidLoad()
        configureViews()
    }
    
    private func configureViews() {
        welcomeLabel.text = stringResources.welcomeMessage.localized()
        getStartedButton.addTarget(self, action: #selector(getStartedAction), for: .touchUpInside)
    }
    
    @objc
    private func getStartedAction() {
        
    }
    
}
