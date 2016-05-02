<%--
  Created by IntelliJ IDEA.
  User: lin
  Date: 2016-05-01-001
  Time: 15:56 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!--content-->
<div id="navigation-slide">
    <div id="navigation">
        <ul class="nav">
            <li><a href="#">进口水果</a></li>
            <li><a href="#">国产水果</a></li>
            <li><a href="#">水果拼盘</a></li>
            <li><a href="#">鲜果礼品</a></li>
        </ul>
    </div>
    <div id="slide">
        <div id="carousel-hot-fruits" class="carousel slide" data-ride="carousel">
            <!-- 导航点 -->
            <ol class="carousel-indicators">
                <li data-target="#carousel-hot-fruits" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-hot-fruits" data-slide-to="1"></li>
                <li data-target="#carousel-hot-fruits" data-slide-to="2"></li>
            </ol>
            <!-- 幻灯容器 -->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img src="<s:url value="/static/img/slides.png"/>" alt="Slide1">
                    <div class="carousel-caption">
                        <p>Slide 1</p>
                    </div>
                </div>
                <div class="item">
                    <img src="<s:url value="/static/img/slides.png"/>" alt="Slide2">
                    <div class="carousel-caption">
                        <p>Slide 2</p>
                    </div>
                </div>
                <div class="item">
                    <img src="<s:url value="/static/img/slides.png"/>" alt="Slide3">
                    <div class="carousel-caption">
                        <p>Slide 3</p>
                    </div>
                </div>
            </div>
            <!-- 控制前后 -->
            <a class="left carousel-control" href="#carousel-hot-fruits" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">上一个</span>
            </a>
            <a class="right carousel-control" href="#carousel-hot-fruits" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">下一个</span>
            </a>
        </div>
    </div>
</div>

<div id="fruit-kinds">
    <div class="panel-group fruits-kind" id="hot-today" role="tablist" aria-multiselectable="true">
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="heading1">
                <h4 class="panel-title">
								<span class="block collapsed" role="button"
                                      data-toggle="collapse" data-parent="#hot-today"
                                      data-target="#collapse1"
                                      aria-expanded="true" aria-controls="collapse">
								今日热卖</span>
                </h4>
            </div><!--.panel-heading-->
            <div id="collapse1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading1">
                <div class="panel-body">
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Recusandae animi obcaecati sed vero
                    pariatur voluptate eos soluta provident! Quam ea praesentium placeat nisi repellat, nam, incidunt
                    pariatur aspernatur perferendis eos.
                </div><!--.panel-body-->
            </div><!--.pabel-collapse-->
        </div><!--.panel-->
    </div><!-- .fruits-kind -->

    <div class="panel-group fruits-kind" id="domestic-fruits" role="tablist" aria-multiselectable="true">
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="heading2">
                <h4 class="panel-title">
								<span class="block collapsed" role="button"
                                      data-toggle="collapse" data-parent="#domestic-fruits"
                                      data-target="#collapse2"
                                      aria-expanded="true" aria-controls="collapse">
								国产水果</span>
                </h4>
            </div><!--.panel-heading-->
            <div id="collapse2" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading2">
                <div class="panel-body">
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Recusandae animi obcaecati sed vero
                    pariatur voluptate eos soluta provident! Quam ea praesentium placeat nisi repellat, nam, incidunt
                    pariatur aspernatur perferendis eos.
                </div><!--.panel-body-->
            </div><!--.pabel-collapse-->
        </div><!--.panel-->
    </div><!-- .fruits-kind -->

    <div class="panel-group fruits-kind" id="imported-fruits" role="tablist" aria-multiselectable="true">
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="heading3">
                <h4 class="panel-title">
								<span class="block collapsed" role="button"
                                      data-toggle="collapse" data-parent="#imported-fruits"
                                      data-target="#collapse3"
                                      aria-expanded="true" aria-controls="collapse">
								进口水果</span>
                </h4>
            </div><!--.panel-heading-->
            <div id="collapse3" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading3">
                <div class="panel-body">
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Recusandae animi obcaecati sed vero
                    pariatur voluptate eos soluta provident! Quam ea praesentium placeat nisi repellat, nam, incidunt
                    pariatur aspernatur perferendis eos.
                </div><!--.panel-body-->
            </div><!--.pabel-collapse-->
        </div><!--.panel-->
    </div><!-- .fruits-kind -->


</div>
<!-- #fruits-kinds -->