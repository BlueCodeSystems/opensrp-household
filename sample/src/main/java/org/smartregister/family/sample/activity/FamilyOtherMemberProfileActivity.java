package org.smartregister.family.sample.activity;

import androidx.viewpager.widget.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import org.smartregister.family.activity.BaseFamilyOtherMemberProfileActivity;
import org.smartregister.family.adapter.ViewPagerAdapter;
import org.smartregister.family.fragment.BaseFamilyOtherMemberProfileFragment;
import org.smartregister.family.model.BaseFamilyOtherMemberProfileActivityModel;
import org.smartregister.family.presenter.BaseFamilyOtherMemberProfileActivityPresenter;
import org.smartregister.family.sample.R;
import org.smartregister.family.sample.fragment.FamilyOtherMemberProfileFragment;
import org.smartregister.family.util.Constants;

public class FamilyOtherMemberProfileActivity extends BaseFamilyOtherMemberProfileActivity {
    @Override
    public String getIntentString(String key) {
        return getIntent() != null ? getIntent().getStringExtra(key) : null;
    }

    @Override
    public void hideProgressDialog() {
        // No-op for sample; no blocking progress shown here
    }

    @Override
    public void showProgressDialog(int messageResourceId) {
        // No-op for sample; progress UI not used here
    }

    @Override
    protected void initializePresenter() {
        String baseEntityId = getIntent().getStringExtra(Constants.INTENT_KEY.BASE_ENTITY_ID);
        String familyHead = getIntent().getStringExtra(Constants.INTENT_KEY.FAMILY_HEAD);
        String primaryCaregiver = getIntent().getStringExtra(Constants.INTENT_KEY.PRIMARY_CAREGIVER);
        String villageTown = getIntent().getStringExtra(Constants.INTENT_KEY.VILLAGE_TOWN);
        presenter = new BaseFamilyOtherMemberProfileActivityPresenter(this, new BaseFamilyOtherMemberProfileActivityModel(), null, baseEntityId, familyHead, primaryCaregiver, villageTown);
    }

    // Not overriding a super method; helper to set up pager
    protected ViewPager setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        BaseFamilyOtherMemberProfileFragment profileOtherMemberFragment = FamilyOtherMemberProfileFragment.newInstance(this.getIntent().getExtras());
        adapter.addFragment(profileOtherMemberFragment, "");

        viewPager.setAdapter(adapter);

        return viewPager;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuItem addMember = menu.findItem(org.smartregister.family.R.id.add_member);
        if (addMember != null) {
            addMember.setVisible(false);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
