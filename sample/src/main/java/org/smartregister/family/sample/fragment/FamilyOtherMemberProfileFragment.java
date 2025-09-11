package org.smartregister.family.sample.fragment;

import android.os.Bundle;
import android.view.View;

import org.smartregister.family.fragment.BaseFamilyOtherMemberProfileFragment;
import org.smartregister.family.model.BaseFamilyOtherMemberProfileFragmentModel;
import org.smartregister.family.presenter.BaseFamilyOtherMemberProfileFragmentPresenter;
import org.smartregister.family.sample.R;
import org.smartregister.family.util.Constants;

import java.util.HashMap;

public class FamilyOtherMemberProfileFragment extends BaseFamilyOtherMemberProfileFragment {
    public static BaseFamilyOtherMemberProfileFragment newInstance(Bundle bundle) {
        Bundle args = bundle;
        BaseFamilyOtherMemberProfileFragment fragment = new FamilyOtherMemberProfileFragment();
        if (args == null) {
            args = new Bundle();
        }
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initializePresenter() {
        String familyBaseEntityId = getArguments().getString(Constants.INTENT_KEY.FAMILY_BASE_ENTITY_ID);
        presenter = new BaseFamilyOtherMemberProfileFragmentPresenter(this, new BaseFamilyOtherMemberProfileFragmentModel(), null, familyBaseEntityId);
    }

    @Override
    protected void onViewClicked(View view) {
        super.onViewClicked(view);
        int id = view.getId();
        if (id == org.smartregister.family.R.id.patient_column) {
            if (view.getTag() != null) { // && view.getTag(org.smartregister.family.R.id.VIEW_ID) == CLICK_VIEW_NORMAL) {
                getActivity().finish();
            }
        }
    }

    @Override
    public void setAdvancedSearchFormData(HashMap<String, String> advancedSearchFormData) {
        //do nothing
    }
  
}
