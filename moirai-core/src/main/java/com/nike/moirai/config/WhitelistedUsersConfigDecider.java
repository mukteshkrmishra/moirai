package com.nike.moirai.config;

import java.util.Collection;
import java.util.function.Predicate;

import static com.nike.moirai.config.ConfigDeciders.userIdCheck;

/**
 * Returns true for a configured list of users.
 *
 * @param <T> the type of config
 * @deprecated use {@link EnabledUsersConfigDecider} instead
 */
@Deprecated
public abstract class WhitelistedUsersConfigDecider<T> extends EnabledUsersConfigDecider<T> {
    @Override
    public final Collection<String> enabledUsers(T config, String featureIdentifier) {
        return whitelistedUsers(config, featureIdentifier);
    }

    /**
     * Provide the collection of users that should have the given feature enabled. Return an empty list if no configuration is provided for the feature.
     *
     * @param config the config source
     * @param featureIdentifier the feature
     * @return the collection of userIds that should be enabled for the feature
     */
    protected abstract Collection<String> whitelistedUsers(T config, String featureIdentifier);
}
