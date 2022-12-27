package observer;

public interface Member {

        /**
         * Update will be called from the observable, and will be used for notify the member
         * and will create an updated UndoableStringBuilder by the parameter provided.
         * @param usb - the original UndoableStringBuilder.
         */
        public void update(UndoableStringBuilder usb);

}
