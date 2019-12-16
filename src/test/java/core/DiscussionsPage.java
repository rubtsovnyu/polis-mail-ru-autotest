package core;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DiscussionsPage extends BasePage {

    private final String mDialogSlr = ".mdialog";
    private final String mDialogListSlr = ".mdialog_list";
    private final String mDialogListTabsSlr = ".mdialog_list_tabs";
    private final String discussionItemSlr = ".mdialog_list_conversations > div[uid=\"discitem\"]";
    private final String mDialogChatSlr = ".mdialog_chat";
    private final String mDialogChatWindowCntSlr = ".mdialog_chat_window_cnt";
    private final String discussionItemTextSlr = ".media-text_cnt_tx";

    public DiscussionsPage() {
        super();
    }

    @Override
    protected void check() {
        $(mDialogSlr).shouldBe(Condition.visible);
    }

    public void openMyDiscussions() {
        final SelenideElement mDialogList = $(mDialogListSlr).shouldBe(Condition.visible);
        final SelenideElement discussionTabs = mDialogList.$(mDialogListTabsSlr).shouldBe(Condition.visible);
        discussionTabs.$("#d-f-tab-fM").click();
    }

    @Deprecated
    public void openNewestDiscussion() {
        final ElementsCollection discs = $$(discussionItemSlr);
        discs.shouldBe(CollectionCondition.sizeGreaterThan(0));
        final SelenideElement lastDiscussion = discs.first();
        lastDiscussion.click();
    }

    public ElementsCollection getDiscussions() {
        return $$(discussionItemSlr);
    }

    public String getOpenedDiscussionText() {
        final SelenideElement mDialogChatElm = $(mDialogChatSlr).shouldBe(Condition.visible);
        final SelenideElement discWindow = mDialogChatElm.$(mDialogChatWindowCntSlr).shouldBe(Condition.visible);
        return discWindow.$(discussionItemTextSlr).shouldBe(Condition.not(Condition.empty)).text();
    }
}
