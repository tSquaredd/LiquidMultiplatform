import UIKit

extension UIColor {

    // swiftlint:disable force_unwrapping
    static var activeButton: UIColor { UIColor(named:"colors/active-button")! }
    // swiftlint:enable force_unwrapping
   
    convenience init(hex: Int, alpha: CGFloat = 1) {
        let red = CGFloat((hex >> 16) & 0xff) / 255.0
        let green = CGFloat((hex >> 08) & 0xff) / 255.0
        let blue = CGFloat((hex >> 00) & 0xff) / 255.0

        self.init(red: red, green: green, blue: blue, alpha: alpha)
    }

}
