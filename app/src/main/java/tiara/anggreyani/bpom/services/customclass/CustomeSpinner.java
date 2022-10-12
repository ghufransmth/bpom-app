package tiara.anggreyani.bpom.services.customclass;

import android.content.Context;
import android.util.AttributeSet;

public class CustomeSpinner extends androidx.appcompat.widget.AppCompatSpinner {

    public CustomeSpinner(Context context)
    { super(context); }

    public CustomeSpinner(Context context, AttributeSet attrs)
    { super(context, attrs); }

    public CustomeSpinner(Context context, AttributeSet attrs, int defStyle)
    { super(context, attrs, defStyle); }

    @Override
    public void
    setSelection(int position, boolean animate)
    {
        boolean sameSelected = position == getSelectedItemPosition();
        super.setSelection(position, animate);
        if (sameSelected) {
            // Spinner does not call the OnItemSelectedListener if the same item is selected, so do it manually now
            getOnItemSelectedListener().onItemSelected(this, getSelectedView(), position, getSelectedItemId());
        }
    }

    @Override
    public void
    setSelection(int position)
    {
        boolean sameSelected = position == getSelectedItemPosition();
        super.setSelection(position);
        if (sameSelected) {
            // Spinner does not call the OnItemSelectedListener if the same item is selected, so do it manually now
            getOnItemSelectedListener().onItemSelected(this, getSelectedView(), position, getSelectedItemId());
        }
    }
}