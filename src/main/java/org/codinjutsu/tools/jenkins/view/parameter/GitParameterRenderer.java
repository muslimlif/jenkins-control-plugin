package org.codinjutsu.tools.jenkins.view.parameter;

import org.codinjutsu.tools.jenkins.model.JobParameter;
import org.codinjutsu.tools.jenkins.model.JobParameterType;
import org.codinjutsu.tools.jenkins.view.extension.JobParameterRenderer;
import org.codinjutsu.tools.jenkins.view.extension.JobParameterRenderers;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class GitParameterRenderer implements JobParameterRenderer {

    @NonNls
    private static final String TYPE_CLASS = "net.uaznia.lukanus.hudson.plugins.gitparameter.GitParameterDefinition";

    static final JobParameterType PT_TAG = new JobParameterType("PT_TAG", TYPE_CLASS);

    static final JobParameterType PT_BRANCH = new JobParameterType("PT_BRANCH", TYPE_CLASS);

    static final JobParameterType PT_BRANCH_TAG = new JobParameterType("PT_BRANCH_TAG", TYPE_CLASS);

    static final JobParameterType PT_REVISION = new JobParameterType("PT_REVISION", TYPE_CLASS);

    static final JobParameterType PT_PULL_REQUEST = new JobParameterType("PT_PULL_REQUEST", TYPE_CLASS);

    private final Map<JobParameterType, BiFunction<JobParameter, String, JobParameterComponent<String>>> converter = new HashMap<>();

    public GitParameterRenderer() {
        converter.put(PT_TAG, GitParameterRenderer::createComponent);
        converter.put(PT_BRANCH, GitParameterRenderer::createComponent);
        converter.put(PT_BRANCH_TAG, GitParameterRenderer::createComponent);
        converter.put(PT_REVISION, GitParameterRenderer::createComponent);
        converter.put(PT_PULL_REQUEST, GitParameterRenderer::createComponent);
    }

    @NotNull
    private static JobParameterComponent<String> createComponent(@NotNull JobParameter jobParameter, String defaultValue) {
        final BiFunction<JobParameter, String, JobParameterComponent<String>> renderer;
        if (jobParameter.getChoices().isEmpty()) {
            renderer = JobParameterRenderers::createTextField;
        } else {
            renderer = JobParameterRenderers::createComboBox;
        }
        return renderer.apply(jobParameter, defaultValue);
    }

    @NotNull
    @Override
    public JobParameterComponent<String> render(@NotNull JobParameter jobParameter) {
        return converter.getOrDefault(jobParameter.getJobParameterType(), JobParameterRenderers::createErrorLabel)
                .apply(jobParameter, jobParameter.getDefaultValue());
    }

    @Override
    public boolean isForJobParameter(@NotNull JobParameter jobParameter) {
        return converter.containsKey(jobParameter.getJobParameterType());
    }
}
