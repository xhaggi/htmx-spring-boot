package io.github.wimdeblauwe.htmx.spring.boot.mvc;

import org.springframework.lang.Nullable;

public final class HtmxRequest {

    private final boolean htmxRequest;
    private final boolean boosted;
    private final String currentUrl;
    private final boolean historyRestoreRequest;
    private final String promptResponse;
    private final String target;
    private final String triggerName;
    private final String triggerId;

    public static Builder builder() {
        return new Builder();
    }

    public static HtmxRequest empty() {
        return new HtmxRequest(false, false, null, false, null, null, null, null);
    }

    HtmxRequest(boolean htmxRequest, boolean boosted, String currentUrl, boolean historyRestoreRequest, String promptResponse, String target, String triggerName, String triggerId) {
        this.htmxRequest = htmxRequest;
        this.boosted = boosted;
        this.currentUrl = currentUrl;
        this.historyRestoreRequest = historyRestoreRequest;
        this.promptResponse = promptResponse;
        this.target = target;
        this.triggerName = triggerName;
        this.triggerId = triggerId;
    }

    public boolean isHtmxRequest() {
        return htmxRequest;
    }

    /**
     * Indicates that the request is via an element using hx-boost.
     *
     * @return true if the request was made via hx-boost, false otherwise
     */
    public boolean isBoosted() {
        return boosted;
    }

    /**
     * The current URL of the browser when the htmx request was made.
     *
     * @return the URL, or null if the URL was not passed
     */
    @Nullable
    public String getCurrentUrl() {
        return currentUrl;
    }

    /**
     * Indicates if the request is for history restoration after a miss in the local history cache
     *
     * @return true if this request is for history restoration, false otherwise
     */
    public boolean isHistoryRestoreRequest() {
        return historyRestoreRequest;
    }

    /**
     * The user response to an hx-prompt.
     *
     * @return The response of the user. Can be null.
     */
    @Nullable
    public String getPromptResponse() {
        return promptResponse;
    }

    /**
     * The id of the target element if it exists.
     *
     * @return the id, or null if no id was passed in the request
     */
    @Nullable
    public String getTarget() {
        return target;
    }

    /**
     * The name of the triggered element if it exists.
     *
     * @return the name of the trigger, or null if no name was passed in the request
     */
    @Nullable
    public String getTriggerName() {
        return triggerName;
    }

    /**
     * The id of the triggered element if it exists.
     *
     * @return the id of the trigger, or null if no name was passed in the request
     */
    @Nullable
    public String getTriggerId() {
        return triggerId;
    }

    public static final class Builder {

        private boolean boosted;
        private String currentUrl;
        private boolean historyRestoreRequest;
        private String promptResponse;
        private String target;
        private String triggerName;
        private String triggerId;

        private Builder() {
        }

        /**
         * @deprecated use {@link #boosted(boolean)} instead. Will be removed in 4.0.
         */
        @Deprecated
        public Builder withBoosted(boolean boosted) {
            return boosted(boosted);
        }

        public Builder boosted(boolean boosted) {
            this.boosted = boosted;
            return this;
        }

        /**
         * @deprecated use {@link #currentUrl(String)} instead. Will be removed in 4.0.
         */
        @Deprecated
        public Builder withCurrentUrl(String currentUrl) {
            this.currentUrl = currentUrl;
            return this;
        }

        public Builder currentUrl(String currentUrl) {
            this.currentUrl = currentUrl;
            return this;
        }

        /**
         * @deprecated use {@link #historyRestoreRequest(boolean)} instead. Will be removed in 4.0.
         */
        @Deprecated
        public Builder withHistoryRestoreRequest(boolean historyRestoreRequest) {
            this.historyRestoreRequest = historyRestoreRequest;
            return this;
        }

        public Builder historyRestoreRequest(boolean historyRestoreRequest) {
            this.historyRestoreRequest = historyRestoreRequest;
            return this;
        }

        /**
         * @deprecated use {@link #promptResponse(String)} instead. Will be removed in 4.0.
         */
        @Deprecated
        public Builder withPromptResponse(String promptResponse) {
            this.promptResponse = promptResponse;
            return this;
        }

        public Builder promptResponse(String promptResponse) {
            this.promptResponse = promptResponse;
            return this;
        }

        /**
         * @deprecated use {@link #target(String)} instead. Will be removed in 4.0.
         */
        @Deprecated
        public Builder withTarget(String target) {
            this.target = target;
            return this;
        }

        public Builder target(String target) {
            this.target = target;
            return this;
        }

        /**
         * @deprecated use {@link #triggerName(String)} instead. Will be removed in 4.0.
         */
        @Deprecated
        public Builder withTriggerName(String triggerName) {
            this.triggerName = triggerName;
            return this;
        }

        public Builder triggerName(String triggerName) {
            this.triggerName = triggerName;
            return this;
        }

        /**
         * @deprecated use {@link #triggerId(String)} instead. Will be removed in 4.0.
         */
        @Deprecated
        public Builder withTriggerId(String triggerId) {
            this.triggerId = triggerId;
            return this;
        }

        public Builder triggerId(String triggerId) {
            this.triggerId = triggerId;
            return this;
        }

        public HtmxRequest build() {
            return new HtmxRequest(true, boosted, currentUrl, historyRestoreRequest, promptResponse, target, triggerName, triggerId);
        }
    }
}
