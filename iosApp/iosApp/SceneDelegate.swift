import UIKit
import SwiftUI

class SceneDelegate: UIResponder, UIWindowSceneDelegate {

    internal var window: UIWindow?

    internal func scene(
        _ scene: UIScene,
        willConnectTo session: UISceneSession,
        options connectionOptions: UIScene.ConnectionOptions
    ) {
        guard (scene as? UIWindowScene) != nil else {
            return
        }
    }

    internal func sceneDidDisconnect(_ scene: UIScene) {
    }

    internal func sceneDidBecomeActive(_ scene: UIScene) {
    }

    internal func sceneWillResignActive(_ scene: UIScene) {
    }

    internal func sceneWillEnterForeground(_ scene: UIScene) {
    }

    internal func sceneDidEnterBackground(_ scene: UIScene) {
    }
}

