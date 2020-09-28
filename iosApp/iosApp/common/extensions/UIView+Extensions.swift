import UIKit

extension UIView {

    var firstResponder: UIView? {
        guard !isFirstResponder else {
            return self
        }

        for subview in subviews {
            if let firstResponder = subview.firstResponder {
                return firstResponder
            }
        }

        return nil
    }

    func pinToSuperView(withMargins margins: UIEdgeInsets = .zero) {
        guard let superview = superview else {
            assertionFailure("Attempting to pin to superview when superview is nil.")
            return
        }

        NSLayoutConstraint.activate(
            [
                topAnchor.constraint(equalTo: superview.topAnchor, constant: margins.top),
                bottomAnchor.constraint(equalTo: superview.bottomAnchor, constant: margins.bottom),
                leadingAnchor.constraint(equalTo: superview.leadingAnchor, constant: margins.left),
                trailingAnchor.constraint(equalTo: superview.trailingAnchor, constant: margins.right)
            ]
        )
    }

}
