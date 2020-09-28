import MaterialComponents

internal enum ButtonUtils {
    internal static func createPrimaryButton(
        withTitle title: String,
        inContainerView containerView: UIView? = nil
    ) -> MDCButton {
        let button = MDCButton()
        button.translatesAutoresizingMaskIntoConstraints = false
        configurePrimaryButton(button, withTitle: title)

        if let containerView = containerView {
            containerView.backgroundColor = .clear
            containerView.addSubview(button)
            button.pinToSuperView()
        }

        return button
    }

    internal static func configurePrimaryButton(_ button: MDCButton, withTitle title: String) {
        button.applyContainedTheme(withScheme: MDCContainerScheme())
        button.setTitle(title, for: .normal)
        button.setTitleColor(.white, for: .normal)
        button.setBackgroundColor(.activeButton, for: .normal)

        NSLayoutConstraint.activate([button.heightAnchor.constraint(equalToConstant: 56)])
    }
}
