package com.mftest.mftestread.analyzers;

import java.util.List;

import com.mftest.mftestread.model.User;

public interface Analyzer {

	public AnalyticsReport analyze(List<User> users);
}
