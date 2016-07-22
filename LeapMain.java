
import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;
import java.io.IOException;



class Listen extends Listener {

    public void onInit(Controller controller) {
        System.out.println("Initialized");
    }

    public void onConnect(Controller controller) {
        System.out.println("Connected");
        controller.enableGesture(Gesture.Type.TYPE_SWIPE);
        controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
        controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
        controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
    }

    public void onDisconnect(Controller controller) {
        //Note: not dispatched when running in a debugger.
        System.out.println("Disconnected");
    }


    public void onExit(Controller controller) {
        System.out.println("Exited");
    }


    public void onFrame(Controller controller) {

        // Initialize Frame
        Frame frame = controller.frame();

        // Initialize Fingers
        Finger userThumb = frame.fingers().fingerType(Finger.Type.TYPE_THUMB).get(0);
        Finger userIndex = frame.fingers().fingerType(Finger.Type.TYPE_INDEX).get(0);
        Finger userMiddle = frame.fingers().fingerType(Finger.Type.TYPE_MIDDLE).get(0);
        Finger userRing = frame.fingers().fingerType(Finger.Type.TYPE_RING).get(0);
        Finger userPinky = frame.fingers().fingerType(Finger.Type.TYPE_PINKY).get(0);

        // Vector Coordinates of Fingertips
        Vector thumbTip = userThumb.tipPosition();
        Vector indexTip = userIndex.tipPosition();
        Vector middleTip = userMiddle.tipPosition();
        Vector ringTip = userRing.tipPosition();
        Vector pinkyTip = userPinky.tipPosition();

        // X and Z proponent of Vectors

        float indX = indexTip.getX();
        float indZ = indexTip.getZ();
        float indY = indexTip.getY();

        float thumbX = thumbTip.getX();
        float thumbZ = thumbTip.getZ();


        float middleX = middleTip.getX();
        float middleZ = middleTip.getZ();

        float ringX = ringTip.getX();
        float ringZ = ringTip.getZ();

        float pinkyX = pinkyTip.getX();
        float pinkyZ = pinkyTip.getZ();

        // Calculating Collision

        float ThumbIndexX = Math.abs(thumbX - indX);
        float ThumbIndexZ = Math.abs(thumbZ - indZ);


        float ThumbMiddleX = Math.abs(thumbX - middleX);
        float ThumbMiddleZ = Math.abs(thumbZ - middleZ);

        float ThumbRingX = Math.abs(thumbX - ringX);
        float ThumbRingZ = Math.abs(thumbZ - ringZ);

        float ThumbPinkyX = Math.abs(thumbX - pinkyX);
        float ThumbPinkyZ = Math.abs(thumbZ - pinkyZ);


        if (ThumbIndexX < 10 && ThumbIndexX != 0 && ThumbIndexZ < 10 && ThumbIndexZ != 0) {
            System.out.println("Index and Thumb Touched.");
        } else if (ThumbMiddleX < 20 && ThumbMiddleX != 0 && ThumbMiddleZ < 30 && ThumbMiddleZ != 0) {
            System.out.println("Middle and Thumb Touched.");
        } else if (ThumbPinkyX < 8 && ThumbPinkyX != 0 && ThumbPinkyZ < 25 && ThumbPinkyZ != 0) {
            System.out.println("Pinky and Thumb Touched.");
        } else if (ThumbRingX < 20 && ThumbRingX != 0 && ThumbRingZ < 20 && ThumbRingZ != 0) {
            System.out.println("Ring and Thumb Touched.");
        }


    }

}


class LeapMain {
    public static void main(String[] args) {
        // Create a sample listener and controller
        Listen listener = new Listen();
        Controller controller = new Controller();

        // Have the sample listener receive events from the controller
        controller.addListener(listener);

        // Keep this process running until Enter is pressed
        System.out.println("Welcome, please place your left hand over the Leap to begin.");


        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Remove the sample listener when done
        controller.removeListener(listener);
    }
}
