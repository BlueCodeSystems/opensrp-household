package org.smartregister.family.sample.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.smartregister.commonregistry.CommonPersonObjectClient;
import org.smartregister.family.fragment.BaseFamilyProfileMemberFragment;
import org.smartregister.family.model.BaseFamilyProfileMemberModel;
import org.smartregister.family.presenter.BaseFamilyProfileMemberPresenter;
import org.smartregister.family.sample.R;
import org.smartregister.family.sample.activity.FamilyOtherMemberProfileActivity;
import org.smartregister.family.util.Constants;

import java.util.HashMap;

public class FamilyProfileMemberFragment extends BaseFamilyProfileMemberFragment {

    public static BaseFamilyProfileMemberFragment newInstance(Bundle bundle) {
        Bundle args = bundle;
        BaseFamilyProfileMemberFragment fragment = new FamilyProfileMemberFragment();
        if (args == null) {
            args = new Bundle();
        }
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initializePresenter() {
        String familyBaseEntityId = getArguments().getString(Constants.INTENT_KEY.FAMILY_BASE_ENTITY_ID);
        String familyHead = getArguments().getString(Constants.INTENT_KEY.FAMILY_HEAD);
        String primaryCareGiver = getArguments().getString(Constants.INTENT_KEY.PRIMARY_CAREGIVER);
        presenter = new BaseFamilyProfileMemberPresenter(this, new BaseFamilyProfileMemberModel(), null, familyBaseEntityId, familyHead, primaryCareGiver);
    }

    @Override
    protected void onViewClicked(View view) {
        super.onViewClicked(view);
        int id = view.getId();
        if (id == org.smartregister.family.R.id.patient_column) {
            if (view.getTag() != null && view.getTag(org.smartregister.family.R.id.VIEW_ID) == CLICK_VIEW_NORMAL) {
                goToOtherMemberProfileActivity((CommonPersonObjectClient) view.getTag());
            }
        }
    }

    public void goToOtherMemberProfileActivity(CommonPersonObjectClient patient) {
        Intent intent = new Intent(getActivity(), FamilyOtherMemberProfileActivity.class);
        intent.putExtras(getArguments());
        intent.putExtra(Constants.INTENT_KEY.BASE_ENTITY_ID, patient.getCaseId());
        startActivity(intent);
    }

    @Override
    public void setAdvancedSearchFormData(HashMap<String, String> advancedSearchFormData) {
        //do nothing
    }
  
}
