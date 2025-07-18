package samples.processor.usage;

import samples.annotations.AccountState;

@AccountState
public record CreditCardAccountState() {
    public void process() {
        // Processing logic for CreditCardAccountState
        CreditCardAccountStateGenerated generated = new CreditCardAccountStateGenerated();
        generated.process();
    }
}
