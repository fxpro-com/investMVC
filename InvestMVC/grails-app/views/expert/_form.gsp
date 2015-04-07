<%@ page import="investmvc.security.Expert" %>



			<div class="${hasErrors(bean: expertInstance, field: 'name', 'error')} ">
				<label for="name" class="control-label"><g:message code="expert.name.label" default="Name" /></label>
				<div>
					<g:textField class="form-control" name="name" value="${expertInstance?.name}"/>
					<span class="help-inline">${hasErrors(bean: expertInstance, field: 'name', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: expertInstance, field: 'chartType', 'error')} ">
				<label for="chartType" class="control-label"><g:message code="expert.chartType.label" default="Chart Type" /></label>
				<div>
					<g:select class="form-control" name="chartType" from="${expertInstance.constraints.chartType.inList}" required="" value="${expertInstance?.chartType}"/>
						<span class="help-inline">${hasErrors(bean: expertInstance, field: 'chartType', 'error')}</span>
				</div>
			</div>

				<div class="${hasErrors(bean: expertInstance, field: 'mathematicalMethods', 'error')} required">
					<label for="mathematicalMethods" class="control-label"><g:message code="expert.mathematicalMethods.label" default="Mathematical Methods" /><span class="required-indicator">*</span></label>
					<div>
						<g:select class="form-control" name="mathematicalMethods" from="${expertInstance.constraints.mathematicalMethods.inList}" required="" value="${expertInstance?.mathematicalMethods}"/>
						<span class="help-inline">${hasErrors(bean: expertInstance, field: 'mathematicalMethods', 'error')}</span>
					</div>
				</div>

			<div class="${hasErrors(bean: expertInstance, field: 'numberOfCandles', 'error')} required">
				<label for="numberOfCandles" class="control-label"><g:message code="expert.numberOfCandles.label" default="Number Of Candles" /><span class="required-indicator">*</span></label>
				<div>
					<g:field class="form-control" name="numberOfCandles" type="number" value="${expertInstance.numberOfCandles}" required=""/>
					<span class="help-inline">${hasErrors(bean: expertInstance, field: 'numberOfCandles', 'error')}</span>
				</div>
			</div>

