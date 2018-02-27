<html id="ng-app" class="js flexbox flexboxlegacy canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb no-hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths page-branded page-branded-buttons page-branded-logo mouse-active" lang="en"><head><style type="text/css">@charset "UTF-8";[ng\:cloak],[ng-cloak],[data-ng-cloak],[x-ng-cloak],.ng-cloak,.x-ng-cloak,.ng-hide:not(.ng-hide-animate){display:none !important;}ng\:form{display:block;}</style><style type="text/css">@charset "UTF-8";[ng\:cloak],[ng-cloak],[data-ng-cloak],[x-ng-cloak],.ng-cloak,.x-ng-cloak,.ng-hide:not(.ng-hide-animate){display:none !important;}ng\:form{display:block;}</style><base href="/"><!--[if lt IE 9]><title>DocuSign</title><![endif]--><meta http-equiv="X-UA-Compatible" content="IE=edge"><meta charset="utf-8"><script type="text/javascript" async="" src="https://docucdn-a.akamaihd.net/v/static/mixpanel-2-2-1b.js"></script><script>window.pageStartTime = new Date()
</script><script>// ie9 is always missing console
if(!(window.console && console.log)) {
  console = {
    log: function(){},
    debug: function(){},
    info: function(){},
    warn: function(){},
    error: function(){}
  };
}</script><!-- Except for embedded scenarios, prevent Martini being embedded in iframes--><meta name="viewport" content="width=device-width,initial-scale=1.0"><title ng-bind="title" class="ng-binding">Envelopes | DocuSign</title><link rel="icon" type="image/x-icon" href="//docucdn-a.akamaihd.net/olive/latest/img/new_favicon.png"><style type="text/css">.site-login .site_content .site_container {
  background-color: #ffffff;
  margin: 0 auto;
  width: 400px;
}
.site-login .content_main {
  padding: 24px;
}</style><script>// Remove the anti-clickjacking node to stop hiding content
(function() {
  var antiClickjack = document.getElementById("antiClickjack");
  antiClickjack.parentNode.removeChild(antiClickjack);
})();</script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>


<style>
.speech {
	border: 1px solid #DDD;
	width: 300px;
	padding: 0;
	margin: 0
}

.speech input {
	border: 0;
	width: 240px;
	display: inline-block;
	height: 30px;
}

.speech img {
	float: right;
	width: 40px
}
</style>

<style type="text/css">a#link-to-fond:hover{background-color:#fff;color:#4e80ff!important}a#link-to-fond:visited{color:#fff}#close-fond-bar:hover{cursor:pointer}#fond-bar{display:block;height:50px;max-height:60px;min-height:10px;background-color:#147bd1;padding:5px 5px 5px 10px;position:fixed;left:0;top:42px;margin-top:-60px;width:100%;z-index:999999;text-align:center;-webkit-box-sizing:initial;box-sizing:initial}#fond-bar-container{display:inline-block;width:98%;margin:0;position:relative;line-height:32px;max-height:32px}#fond-text{position:relative;color:#fff!important;font-size:16px!important;text-align:centecenter!important;margin:0!important;float:left!important;text-shadow:none!important;padding:4px!important;line-height:60px;vertical-align:middle;width:100%}#fond-text,#link-to-fond{font-family:walsheim,Arial!important}#link-to-fond{color:#fff;font-size:14px!important;font-weight:400!important;border:1px solid #fff;padding:6px 20px;border-radius:2px;text-decoration:none!important;margin-left:12px}#fond-small{width:24px;height:24px;margin-right:8px;margin-top:-2px;vertical-align:middle;display:inline!important}#close-fond-bar{position:absolute;top:26px;right:5px;width:14px;z-index:999999;font-family:Arial;font-size:12px}</style><link rel="stylesheet" href="https://docucdn-a.akamaihd.net/olive/18.2.0/css/olive.min.css"><link rel="stylesheet" href="https://docucdn-a.akamaihd.net/olive/18.2.0/css/sending.min.css"><script src="https://docucdn-a.akamaihd.net/olive/18.2.0/js/olive-angular.min.js"></script><style id="olive-css-mouse-active" type="text/css">
        .mouse-active :focus:not(input):not(select):not(textarea):not(.tile) {
            box-shadow: none !important;
            outline: 0 !important;
            text-decoration: none !important;
        }
        .mouse-active .menu .item:focus:not(:hover):not(.menu_item-isOn),
        .mouse-active .menu_item:focus:not(:hover):not(.menu_item-isOn) {
            background-color: inherit;
        }
        </style><style type="text/css">.c1-ui-state-hover {background-color:yellow !important; padding:5px !important }</style><style id="styles-branded" type="text/css">
            .page-branded .header {
                background-color: #cc3333;
            }
            .page-branded .header_name,
            .page-branded .header_title {
                border-left-color: #FFFFFF;
            }
            .page-branded .header_name,
            .page-branded .header_title {
                color: #FFFFFF;
            }
            .page-branded .header_logo svg {
                fill: #FFFFFF;
            }
            .page-branded .header .nav_item,
            .page-branded .header_action,
            .page-branded .nav_link {
                color: #FFFFFF;
            }
            .page-branded .header .nav_item:hover,
            .page-branded .header .header_action:hover,
            .page-branded .header .nav_link:hover {
                background: #ff4242;
                color: #FFFFFF;
            }
            .page-branded .header .nav_item.on,
            .page-branded .header .header_action.menu_trigger-on,
            .page-branded .header .nav_link.menu_trigger-on {
                background: #8f2424;
            }
            .page-branded .hero {
                background: #8f2424;
                color: #FFFFFF;
            }
            .page-branded-buttons .btn-main,
            .page-branded-buttons .btn-main.menu_trigger-on {
                border-color: #ffc820;
                background: #ffc820;
                color: #333333;
            }
            .page-branded-buttons .btn-main:hover {
                background: #f7c11f;
                border-color: #f7c11f;
            }
            .page-branded-buttons .btn-main:active {
                background: #eebb1e;
                border-color: #eebb1e;
            }
            .page-branded-buttons .btn-primary,
            .page-branded-buttons .btn-primary.menu_trigger-on {
                border-color: #ffc820;
                background: #ffc820;
                color: #333333;
            }
            .page-branded-buttons .btn-primary:hover {
                background: #f7c11f;
                border-color: #f7c11f;
            }
            .page-branded-buttons .btn-primary:active {
                background: #eebb1e;
                border-color: #eebb1e;
            }
            .page-branded-logo .header-ndse .header_logo {
                background-image: url('/brands/4fc41671-ddf2-491c-9fa1-a0f4dcd519bd/logos/primary?1518111828745');
            }
        
                .page-branded-logo .header-ndse .header_logo {
                    background-color: #cc3333;
                }
            </style></head>
            
            
<body ds-events="" page-style="" translate-cloak="" class=""><!-- uiView:  -->




<div ui-view="" class="ng-scope"><!-- ngIf: enableApp --><div class="site site-classic ng-scope" ng-if="enableApp">

    <!-- Site structure -->
    <div class="site_wrap">
        <!-- ngInclude: 'common/templates/site-header.html' --><nav-header class="ng-scope ng-isolate-scope"><div ng-switch="navHeader.isMeerkatEnabled">
    <!-- ngSwitchWhen: true -->
    <!-- ngSwitchDefault:  --><div class="site_header header header-ndse header-ndse-compat ng-scope" data-qa="header-wrapper" ng-switch-default="">
        <ng-transclude>
  <div class="header_wrap ng-scope">

    <div class="header_nav-mobile header_actions">
      <button type="button" ds-mobile-menu="navMenu" data-qa="hamburger-menu" ds-mobile-menu-side="left" class="header_action">
        <span class="icon icon-menu-hamburger"></span>
        <span class="sr-text ng-binding">Menu</span>
      </button>
    </div>

    <!-- main logo -->
    <div class="header_left">
      <a class="header_logo ng-scope" ng-href="/home" href="/home" ds-analytics="header-logo" data-qa="header-logo">
          <img ng-src="https://docucdn-a.akamaihd.net/olive/18.2.0/img/Logo-DS-White.svg" ng-attr-alt="{{ 'Logo' | dsTranslate }}" src="https://docucdn-a.akamaihd.net/olive/18.2.0/img/Logo-DS-White.svg" alt="Logo">
      </a>
    </div>

    <!-- main navigation -->
    <div class="header_main ng-scope" ng-controller="MainNavController">
      <nav>
        <ul class="nav_list">
          <li>
            <a ng-class="{'on': $location.path().indexOf('/home') == 0}" href="/home" class="nav_item ng-scope ng-binding" ds-analytics="header-home" data-qa="header-home">
                <span class="icon icon-home"></span> Home
            </a>
          </li>
          <li>
            <!-- a11y - MAR-23750 - this anchor element needs an href -->
            <a ng-class="{'on': $location.path().indexOf('/documents') == 0}" ng-href="/documents?view=sent" class="nav_item ng-scope ng-binding on" ds-analytics="header-documents" data-qa="header-documents" data-callout="documents-tab" href="/documents?view=sent">
                <span class="icon icon-documents"></span> Manage
            </a>
          </li>
          <!-- ngIf: showTemplatesLink --><li ng-if="showTemplatesLink" ng-switch="isTemplatesFeatureWalled" class="ng-scope">
              <!-- ngSwitchWhen: true -->
              <!-- ngSwitchDefault:  --><a ng-switch-default="" ng-class="{'on': $location.path().indexOf('/templates') == 0}" ng-href="/templates" class="nav_item ng-scope ng-binding" ds-analytics="header-templates" data-qa="header-templates" data-callout="templates-tab" href="/templates">
                  <span class="icon icon-templates"></span> Templates
              </a><!-- end ngSwitchWhen: -->
          </li><!-- end ngIf: showTemplatesLink -->
          <!-- ngIf: Featured('showReportsFF') --><li ng-if="Featured('showReportsFF')" class="ng-scope">
              <a ng-class="{'on': $location.path().indexOf('/reports') == 0}" href="/reports" class="nav_item ng-scope ng-binding" ds-analytics="header-reports" data-qa="header-reports">
                  <span class="icon icon-reports"></span> Reports
              </a>
          </li><!-- end ngIf: Featured('showReportsFF') -->
        </ul>
      </nav>
    </div>
    <!-- ngInclude: 'common/templates/site-header-dropdown.html' --><div class="header_right ng-scope" ng-controller="SubNavController">
  <!-- ngIf: showUpgradeInfo --><div ng-if="showUpgradeInfo" class="ng-scope">
    <!-- ngIf: showDaysLeft -->
      <!-- ngIf: upgrade.enableHeaderLink -->
    </div><!-- end ngIf: showUpgradeInfo -->
    <div class="header_actions" ng-switch="helpMenuType">

        <!-- a11y - MAR-23750 - this anchor element needs an href -->
        <!-- ngIf: conversationsEnabled -->

        <!-- help and support dropdown -->
        <!-- meerkat menu outside prepare -->
        <!-- ngSwitchWhen: meerkat -->
        <!-- meerkat menu inside prepare -->
        <!-- ngSwitchWhen: meerkat-prepare -->

        <!-- ngSwitchDefault:  --><a target="_blank" ng-href="//support.docusign.com/guides/ndse-user-guide-managing-documents" ds-help-drawer="helpDrawer" ng-attr-ds-help-drawer-url="{{ help.drawerUrl || undefined }}" class="header_action hidden-md-down ng-scope" data-qa="header-help" ds-analytics="help-nav" ng-switch-default="" ng-click="trackSupportClick(help.currentPage)" href="//support.docusign.com/guides/ndse-user-guide-managing-documents">
            <i class="icon icon-help"></i>
            <span class="vh ng-binding">Help</span>
        </a><!-- end ngSwitchWhen: -->

        <!-- profile pic dropdown -->
        <button type="button" class="header_action" olive-menu="menuAccountNav" olive-menu-position="below right" olive-menu-trigger="menuAccountNav" olive-menu-min-width="254" data-qa="header-account-dropdown" profile-image="defaultAccount" ds-size-profile="" olive-menu-initialized="true" aria-haspopup="true" aria-expanded="false">
            <!-- ngIf: $props.profileImage --><span ng-if="$props.profileImage" class="avatar avatar-medium avatar-background avatar-placeholder ng-scope">
            </span><!-- end ngIf: $props.profileImage -->
        </button>

        <!-- dropdown body for profile pic -->
        <div id="menuAccountNav" class="menu invisible" data-qa="menuAccountNav" olive-menu-content-for="menuAccountNav" style="opacity: 0; min-width: 254px;">

            <div class="menu-section">
                <!-- ngInclude: 'common/templates/id-card.html' --><style type="text/css" class="ng-binding ng-scope">.avatar-background{background-image: url(data:image/gif;base64,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)}</style><div class="l-media ng-scope">
    <div class="l-media_image">
        <!-- ngIf: $props.profileImage --><span ng-if="$props.profileImage" class="avatar avatar-xlarge avatar-background avatar-placeholder ng-scope">
        </span><!-- end ngIf: $props.profileImage -->
    </div>
    <div class="l-media_body">
        <div><strong data-qa="header-account-name" class="ng-binding">DocuSign Test API</strong></div>
        <!-- ngIf: currentAccountIsDefault() --><div ng-if="currentAccountIsDefault()" class="text-muted ng-binding ng-scope">(Default)</div><!-- end ngIf: currentAccountIsDefault() -->
        <div data-qa="header-account-email" class="ng-binding">amitkumar.bist+test@gmail.com</div>
        <div class="ng-binding">1764240</div>
        <!-- ngIf: Featured('account').is21CFRPart11 -->
    </div>
</div>
            </div>
            
            <ul class="menu-grouping" role="menu" aria-label="">
                <!-- ngIf: isRADminAvailable --><li ng-if="isRADminAvailable" class="ng-scope" role="menuitem">
                    <form action="/redirect-to-admin" method="post" class="ng-pristine ng-valid">
                        <button type="submit" data-qa="go-to-admin" class="item ng-scope ng-binding" ds-analytics="header-admin-nav">
                            Go to Admin</button>
                    </form>
                </li><!-- end ngIf: isRADminAvailable -->
                <li role="menuitem">
                    <a href="/preferences" class="item ng-binding">My Preferences</a>
                </li>
                <!-- ngIf: accounts.length > 1 -->
                <!-- ngIf: canSwitchBack --><li ng-if="canSwitchBack" class="ng-scope" role="menuitem">
                    <button class="item ng-binding" ng-click="switchToClassic()" type="button">
                        Switch to Classic
                    </button>
                </li><!-- end ngIf: canSwitchBack -->
                <!-- ngIf: allowTransactionRooms --><li ng-if="allowTransactionRooms" class="ng-scope" role="menuitem">
                    <button class="item ng-binding" ng-click="switchToTransactionRooms()" ng-class="{ 'menu_item-highlight': highlightDTR }" type="button">
                        Switch to Transaction Rooms
                    </button>
                </li><!-- end ngIf: allowTransactionRooms -->
                <li role="menuitem">
                    <button type="button" class="item ng-binding" olive-modal-trigger="modalFeedback" olive-modal-template-url="common/templates/feedback.html" olive-modal-size="lg" data-qa="header-feedback">
                        Feedback
                    </button>
                </li>
                <li class="hidden-md-up" role="menuitem">
                    <a class="item ng-binding" target="_blank" data-qa="help-link-avatar-menu" href="https://support.docusign.com/knowledgeSearch?by=product&amp;product=new_docusign_experience&amp;topic=all">
                        Help
                    </a>
                </li>
                <li role="menuitem">
                    <a class="item ng-binding" target="_self" href="/logout" data-qa="header-log-out">
                        Log Out
                    </a>
                </li>
            </ul>
        </div>

        <!-- ngIf: helpMenuType === 'meerkat' -->
    </div>
</div>
  </div>

  <!-- hamburger menu body -->
  <!-- ngIf: mobileView -->
</ng-transclude>
    </div><!-- end ngSwitchWhen: -->
</div>
</nav-header>
        <status-bar-container class="ng-isolate-scope"><!-- ngIf: $props.hasStatus -->
</status-bar-container>
        <!-- uiView:  --><div class="site_content content loading ng-scope" ui-view=""><div class="content_wrap ng-isolate-scope">
    <div class="content_left resizable ng-isolate-scope">

    <!-- Resize -->
    <div class="resize-horizontal resize-right resize-line ng-isolate-scope"></div>

    <!-- Actions / Shared users -->
    <div class="sidebar_group">

        <!-- Create button -->
        <!-- ngIf: $props.userIsCurrent --><envelopes-new-actions-button page-name="docs" ng-if="$props.userIsCurrent" class="ng-scope ng-isolate-scope"><!-- ngIf: $props.canSend --><div ng-class="{
    'sidebar_item': !component.showHero
    }" ng-if="$props.canSend" ng-switch="component.showMeerkat" class="ng-scope sidebar_item">
    <!-- Meerkat button -->
    <!-- ngSwitchWhen: true -->
    <!-- Button -->
    <!-- ngSwitchDefault:  --><button ng-switch-default="" class="btn btn-main ng-binding ng-scope btn-full btn-lg" type="button" ng-class="{
            'btn-full': !component.showHero,
            'btn-lg': !component.showHero,
            'btn-xl': component.showHero,
            'hero-action': component.showHero
        }" olive-menu="menuNewDocument" data-callout="envelope-new-button" data-qa="button-new-document" ng-click="component.onNewButtonClick()" olive-menu-trigger="menuNewDocument" olive-menu-initialized="true" aria-haspopup="true" aria-expanded="false">
        New
    </button><!-- end ngSwitchWhen: -->
    <!-- Button menu -->
    <!-- ngSwitchDefault:  --><div id="menuNewDocument" class="menu invisible ng-scope" data-callout="envelope-new-dropdown" ng-switch-default="" style="opacity: 0; min-width: 172px;">
        <ul role="menu" aria-label="
        New
    ">
            <li ng-click="component.sendEnvelope()" role="menuitem">
                <!-- ngIf: $props.canSendEnvelope --><button class="item ng-scope ng-binding" type="button" data-qa="link-create-new-document" ng-if="$props.canSendEnvelope" ds-analytics="docs-mutton-send">
                    Send an Envelope
                </button><!-- end ngIf: $props.canSendEnvelope -->
            </li>
            <!-- ngIf: $props.canSignEnvelope --><li ng-click="component.signEnvelope()" ng-if="$props.canSignEnvelope" class="ng-scope" role="menuitem">
                <button class="item ng-scope ng-binding" type="button" data-qa="link-sign-new-document" ds-analytics="docs-mutton-sign">
                    Sign a Document
                </button>
            </li><!-- end ngIf: $props.canSignEnvelope -->
            <!-- ngIf: $props.canUseTemplate --><li ng-click="component.useTemplate()" ng-if="$props.canUseTemplate" class="ng-scope" role="menuitem">
                <button class="item ng-scope ng-binding" type="button" data-qa="link-use-template" ds-analytics="docs-mutton-template">
                    Use a Template
                </button>
            </li><!-- end ngIf: $props.canUseTemplate -->
        </ul>
    </div><!-- end ngSwitchWhen: -->
</div><!-- end ngIf: $props.canSend -->
</envelopes-new-actions-button><!-- end ngIf: $props.userIsCurrent -->

        <!-- Shared users -->
        <shared-users-button class="ng-isolate-scope"><!-- ngIf: component.showSharedUsers() --><div class="sidebar_item ng-scope" ng-if="component.showSharedUsers()">
    <!-- Button to trigger shared user modal -->
    <button type="button" class="btn btn-secondary btn-block btn-viewAs ng-binding" data-qa="button-shared-users" olive-menu="users" ng-click="component.open()" data-callout="manage-shared">
        Shared Envelopes
    </button>
</div><!-- end ngIf: component.showSharedUsers() -->
</shared-users-button>
    </div>

    <!-- Folders / PowerForms -->
    <div class="sidebar_group">
        <envelopes-views class="ng-isolate-scope"><div class="sidebar_item">
    <h4 class="sidebar_title ng-binding">
        Envelopes
    </h4>
    <div class="menu-nav">
        <ul class="menu_list">
            <li class="menu_listItem ng-isolate-scope" data-qa="Inbox-folder" key="inbox" name="Inbox" icon="icon-inbox" drop-options="{&quot;context&quot;:&quot;inbox&quot;}">

    <!-- ngIf: !component.dropOptions -->

    <!-- ngIf: component.dropOptions --><a ng-if="component.dropOptions" class="menu_item ng-scope ui-droppable" ng-class="{ 'menu_item-isOn': $props.isSelected }" ng-href="/documents?view=inbox" ds-drop="" ds-drop-options="{&quot;context&quot;:&quot;inbox&quot;}" href="/documents?view=inbox">

        <!-- Folder name and icon -->
        <span class="menu_itemIcon icon-inbox" ng-class="component.icon"></span>
        <span class="ng-binding">Inbox</span>
    </a><!-- end ngIf: component.dropOptions -->
</li>
            <li class="menu_listItem ng-isolate-scope" data-qa="Sent-folder" key="sent" name="Sent" icon="icon-sent" drop-options="{&quot;context&quot;:&quot;sentitems&quot;}">

    <!-- ngIf: !component.dropOptions -->

    <!-- ngIf: component.dropOptions --><a ng-if="component.dropOptions" class="menu_item ng-scope ui-droppable menu_item-isOn" ng-class="{ 'menu_item-isOn': $props.isSelected }" ng-href="/documents?view=sent" ds-drop="" ds-drop-options="{&quot;context&quot;:&quot;sentitems&quot;}" href="/documents?view=sent">

        <!-- Folder name and icon -->
        <span class="menu_itemIcon icon-sent" ng-class="component.icon"></span>
        <span class="ng-binding">Sent</span>
    </a><!-- end ngIf: component.dropOptions -->
</li>
            <!-- ngIf: $props.userIsCurrent --><li class="menu_listItem ng-isolate-scope" data-qa="Drafts-folder" ng-if="$props.userIsCurrent" key="draft" name="Drafts" icon="icon-draft">

    <!-- ngIf: !component.dropOptions --><a ng-if="!component.dropOptions" class="menu_item ng-scope" ng-class="{ 'menu_item-isOn': $props.isSelected }" ng-href="/documents?view=draft" href="/documents?view=draft">

        <!-- Folder name and icon -->
        <span class="menu_itemIcon icon-draft" ng-class="component.icon"></span>
        <span class="ng-binding">Drafts</span>
    </a><!-- end ngIf: !component.dropOptions -->

    <!-- ngIf: component.dropOptions -->
</li><!-- end ngIf: $props.userIsCurrent -->
            <li class="menu_listItem ng-isolate-scope" data-qa="Deleted-folder" key="deleted" name="Deleted" icon="icon-trash" drop-options="{&quot;context&quot;:&quot;recyclebin&quot;}">

    <!-- ngIf: !component.dropOptions -->

    <!-- ngIf: component.dropOptions --><a ng-if="component.dropOptions" class="menu_item ng-scope ui-droppable" ng-class="{ 'menu_item-isOn': $props.isSelected }" ng-href="/documents?view=deleted" ds-drop="" ds-drop-options="{&quot;context&quot;:&quot;recyclebin&quot;}" href="/documents?view=deleted">

        <!-- Folder name and icon -->
        <span class="menu_itemIcon icon-trash" ng-class="component.icon"></span>
        <span class="ng-binding">Deleted</span>
    </a><!-- end ngIf: component.dropOptions -->
</li>
            <!-- ngIf: $props.displayPowerforms -->
        </ul>
    </div>
</div>
</envelopes-views>
        <folders-smart-list class="ng-isolate-scope"><div class="sidebar_item">
    <h4 class="sidebar_title ng-binding" data-callout="manage-filters">
        Quick Views
    </h4>
    <div class="menu-nav">
        <ul class="menu_list">
            <!-- ngRepeat: folder in component.folders track by folder.key --><li class="menu_listItem ng-isolate-scope" ng-repeat="folder in component.folders track by folder.key" key="action-required" name="Action Required" icon="icon-action-required">
    <a class="menu_item" ng-class="{ 'menu_item-isOn': $props.isSelected }" ng-href="/documents?label=action-required" href="/documents?label=action-required">
        <span data-qa="smart-folder-Action Required">
            <span class="menu_itemIcon icon-action-required" ng-class="component.icon"></span>
            <span class="ng-binding">Action Required</span>
        </span>
    </a>
</li><!-- end ngRepeat: folder in component.folders track by folder.key --><li class="menu_listItem ng-isolate-scope" ng-repeat="folder in component.folders track by folder.key" key="waiting-for-others" name="Waiting for Others" icon="icon-clock">
    <a class="menu_item" ng-class="{ 'menu_item-isOn': $props.isSelected }" ng-href="/documents?label=waiting-for-others" href="/documents?label=waiting-for-others">
        <span data-qa="smart-folder-Waiting for Others">
            <span class="menu_itemIcon icon-clock" ng-class="component.icon"></span>
            <span class="ng-binding">Waiting for Others</span>
        </span>
    </a>
</li><!-- end ngRepeat: folder in component.folders track by folder.key --><li class="menu_listItem ng-isolate-scope" ng-repeat="folder in component.folders track by folder.key" key="expiring-soon" name="Expiring Soon" icon="icon-alert">
    <a class="menu_item" ng-class="{ 'menu_item-isOn': $props.isSelected }" ng-href="/documents?label=expiring-soon" href="/documents?label=expiring-soon">
        <span data-qa="smart-folder-Expiring Soon">
            <span class="menu_itemIcon icon-alert" ng-class="component.icon"></span>
            <span class="ng-binding">Expiring Soon</span>
        </span>
    </a>
</li><!-- end ngRepeat: folder in component.folders track by folder.key --><li class="menu_listItem ng-isolate-scope" ng-repeat="folder in component.folders track by folder.key" key="completed" name="Completed" icon="icon-completed">
    <a class="menu_item" ng-class="{ 'menu_item-isOn': $props.isSelected }" ng-href="/documents?label=completed" href="/documents?label=completed">
        <span data-qa="smart-folder-Completed">
            <span class="menu_itemIcon icon-completed" ng-class="component.icon"></span>
            <span class="ng-binding">Completed</span>
        </span>
    </a>
</li><!-- end ngRepeat: folder in component.folders track by folder.key -->
        </ul>
    </div>
</div></folders-smart-list>
        <folders-tree class="ng-isolate-scope"><div class="sidebar_item" data-callout="manage-folders">
    <div class="tree tree-sidebar" data-qa="folderList">
        <ul class="tree_list">
            <li>
                <!-- Folder info -->
                <span class="tree_title">

                    <!-- Open / Close icon for folder -->
                    <!-- ngIf: $props.hasFolders --><span class="tree_itemTrigger ng-scope ng-isolate-scope icon-menu-triangle-down" ng-class="{
                            'icon-menu-triangle-down': $props.opened,
                            'icon-menu-triangle-right': !$props.opened }" ng-if="$props.hasFolders" ng-click="component.toggleOpen()" stop-propagation="">
                    </span><!-- end ngIf: $props.hasFolders -->

                    <!-- Folder name and icon -->
                    <span class="tree_itemText">
                        <!-- ngIf: $props.userIsCurrent --><button type="button" ng-if="$props.userIsCurrent" class="btn btn-minor btn-icon tree_itemIconRight ng-scope ng-isolate-scope" ng-click="component.create()" data-qa="menu-new-folder" stop-propagation="">
                            <span class="icon icon-add" olive-tooltip="c5716154-78d8-4cca-2dd4-c225242ad00d" ng-attr-title="{{ 'New Folder' | dsTranslate }}" olive-tooltip-initialized="true" olive-tooltip-trigger="c5716154-78d8-4cca-2dd4-c225242ad00d">
                            </span>
                        </button><!-- end ngIf: $props.userIsCurrent -->
                        <h4 class="sidebar_title ng-binding">
                            Folders
                        </h4>
                    </span>
                </span>
            </li>
        </ul>

        <!-- Recursive subfolders -->
        <!-- ngIf: $props.opened --><ul class="tree_list tree_list-folders ng-scope" ng-if="$props.opened" data-qa="subFolderList">

            <!-- ngRepeat: folderId in $props.folders track by folderId --><li ds-drag="" ds-drag-options="component.dragOptions()" ng-style="{ opacity: 1 }" ng-repeat="folderId in $props.folders track by folderId" folder-id="3878737f-c880-43df-9cbb-ddc24be58f81" class="ng-isolate-scope ui-draggable ui-draggable-handle" style="opacity: 1;">

    <!-- Folder info -->
    <a class="tree_item ng-scope ui-droppable" ng-class="{ 'tree_item-isActive': $props.isSelected }" ng-href="/documents?folder=3878737f-c880-43df-9cbb-ddc24be58f81" ds-drop="" ds-drop-options="component.dropOptions" href="/documents?folder=3878737f-c880-43df-9cbb-ddc24be58f81">

        <!-- Open / Close icon for folder -->
        <!-- ngIf: $props.hasFolders -->

        <!-- Folder name, icon and actions -->
        <span class="tree_itemText" ng-attr-title="{{ $props.name }}" title="SaveDeletedFiles">
            <span class="tree_itemIcon icon-folder"></span>
            <span data-qa="folder-title-save-deleted-files" class="ng-binding">SaveDeletedFiles</span>

            <!-- Folder actions -->
            <!-- ngIf: $props.userIsCurrent --><button type="button" class="btn btn-minor btn-icon tree_itemAction ng-scope ng-isolate-scope" ng-if="$props.userIsCurrent" prevent-default="" olive-menu="actions-3878737f-c880-43df-9cbb-ddc24be58f81" olive-position="below left" olive-tooltip="4b73ca1d-8189-4524-dee8-ea7f4d122566" ng-attr-title="{{ 'Actions' | dsTranslate }}" olive-tooltip-position="above center" data-qa="menu-filter-folder-save-deleted-files" olive-tooltip-initialized="true" olive-tooltip-trigger="4b73ca1d-8189-4524-dee8-ea7f4d122566" olive-menu-trigger="actions-3878737f-c880-43df-9cbb-ddc24be58f81" olive-menu-initialized="true" aria-haspopup="true" aria-expanded="false">
                <i class="icon icon-ellipsis-vert"></i>
                <span class="sr-text ng-binding">Actions</span>
            </button><!-- end ngIf: $props.userIsCurrent -->

        </span>
    </a>

    <!-- Folder actions menu -->
    <!-- ngIf: $props.userIsCurrent --><div class="menu invisible ng-scope" id="actions-3878737f-c880-43df-9cbb-ddc24be58f81" ng-if="$props.userIsCurrent" style="opacity: 0; min-width: 120px;">
        <ul role="menu" aria-label="
                
                Actions
            ">
            <li role="menuitem">
                <a class="item ng-binding" ng-click="component.openUpdate()" data-qa="rename-folder-save-deleted-files">Rename</a>
            </li>
            <li role="menuitem">
                <a class="item ng-binding" ng-click="component.openMove()" data-qa="move-folder-save-deleted-files">Move</a>
            </li>
            <li role="menuitem">
                <a class="item ng-binding" ng-click="component.openRemove()" data-qa="delete-folder-save-deleted-files">Delete</a>
            </li>
            <li role="menuitem">
                <a class="item ng-binding" ng-click="component.openCreate()" data-qa="create-subfolder-save-deleted-files">New Subfolder</a>
            </li>
        </ul>
    </div><!-- end ngIf: $props.userIsCurrent -->

    <!-- Recursive subfolders -->
    <!-- ngIf: $props.opened -->
</li><!-- end ngRepeat: folderId in $props.folders track by folderId -->

            <!-- ngIf: $props.hasMore -->
        </ul><!-- end ngIf: $props.opened -->
    </div>
</div>
</folders-tree>
        <!-- ngIf: component.showPowerformsTree --><powerforms-tree ng-if="component.showPowerformsTree" class="ng-scope ng-isolate-scope"><!-- ngIf: $props.showPowerForms --><div class="sidebar_item ng-scope" ng-if="$props.showPowerForms">

    <!-- Powerforms tree -->
    <div class="tree tree-sidebar">
        <ul class="tree_list" ng-switch="$props.showPowerFormUpgrade">

            <!-- Show powerforms feature wall -->
            <!-- ngSwitchWhen: true -->

            <!-- Has one root powerform label -->
            <!-- ngSwitchDefault:  -->
            <li ng-switch-default="" class="ng-scope">
                <span class="tree_title">

                    <!-- Open / Close icon for powerForm -->
                    <span class="tree_itemTrigger icon-menu-triangle-right" ng-click="component.toggleOpen()" ng-class="{
                            'icon-menu-triangle-down': $props.opened,
                            'icon-menu-triangle-right': !$props.opened }" data-qa="tree-powerform">
                    </span>

                    <!-- Folder name and icon -->
                    <span class="tree_itemText">
                        <h4 class="sidebar_title ng-binding" data-qa="powerform-dropdown">
                            PowerForms
                        </h4>
                    </span>
                </span>
            </li><!-- end ngSwitchWhen: -->
            <li ng-switch-default="" class="ng-scope">
                <span class="tree_title">

					     <form id="labnol" method="get" action="hackathon/getRecipientViewUrl">
							<div class="speech">
					
								<input type="text" name="q" id="transcript" placeholder="Speak" style="display:none"/>
								<input
									type="hidden" name="envelopeId" id="envelopeId"
									value="${envelopeId}" /> 
								<input type="submit"
									style="position: absolute; left: -9999px; width: 1px; height: 1px;"
									tabindex="-1" />
					
							</div>
							<div id="failedErrorMsg"></div>
						</form>
                </span>
            </li><!-- end ngSwitchWhen: -->
        </ul>

        <!-- List of powerforms -->
        <!-- ngIf: $props.visible -->

        <!-- Empty list powerforms -->
        <!-- ngIf: $props.showEmpty -->
    </div>
</div><!-- end ngIf: $props.showPowerForms -->
</powerforms-tree><!-- end ngIf: component.showPowerformsTree -->
    </div>
</div>
    <div class="content_main ng-isolate-scope" ng-switch="$props.view">

    <!-- We selling powerforms up in here -->
    <!-- ngSwitchWhen: powerformsUpgrade -->

    <!-- ngSwitchWhen: powerforms -->

    <!-- ngSwitchDefault:  --><envelopes-list-view ng-switch-default="" class="ng-scope ng-isolate-scope"><div ng-switch="$props.empty">

    <!-- Show the correct header for the view based on props -->
    <div style=""><div class="listHeaderWrap cheshireContainer" olive-sticky="docListHeader" olive-sticky-on="sticky-listHeader" olive-sticky-initialized="true" style="">

        <!-- Search box -->
        <div class="listHeader">
            <div ng-switch="$props.checked">

                <!-- Action Buttons -->
                <!-- ngSwitchWhen: true -->

                <!-- Search bar -->
                <!-- ngSwitchDefault:  --><envelopes-header ng-switch-default="" class="ng-scope ng-isolate-scope"><!-- Title row -->
<div class="listHeader_titleRow fgrid">

    <!-- Title -->
    <div class="fgrid_cell" ng-switch="$props.context">

        <!-- Powerform header info -->
        <!-- ngSwitchWhen: powerform -->

        <!-- Envelopes info header -->
        <!-- ngSwitchDefault:  --><div ng-switch-default="" class="ng-scope">
            <h1 class="listHeader_heading" ng-switch="$props.context">
                <!-- ngSwitchWhen: everything -->
                <!-- ngSwitchWhen: inbox -->
                <!-- ngSwitchWhen: sent --><span ng-switch-when="sent" class="ng-binding ng-scope">Sent</span><!-- end ngSwitchWhen: -->
                <!-- ngSwitchWhen: draft -->
                <!-- ngSwitchWhen: deleted -->
                <!-- ngSwitchWhen: quick -->
                <!-- ngSwitchDefault:  -->
            </h1>
        </div><!-- end ngSwitchWhen: -->
    </div>

    <!-- Filter -->
    <div class="fgrid_cell fgrid_cell-auto">
        <envelopes-filters-input class="ng-isolate-scope">
        <form ng-submit="component.submit()" class="u-inline-block ng-pristine ng-valid">
    <!-- Visible every time -->
    <span class="cheshire_visibleContent u-inline-block" olive-cheshire-noclose="envelopesFilter" olive-cheshire-visible="envelopesFilter">

        <!-- Search -->
        <span class="listHeader_search" ng-click="component.openFilters()">
            <div class="form_item-iconLeft form_item-iconRight">
                <span class="icon icon-search"></span>
                <input type="text" class="input-text ng-pristine ng-untouched ng-valid" data-qa="input-search" ng-attr-placeholder="{{ $props.searchContext }}" ng-attr-aria-label="{{ $props.searchContext }}" ng-model="$props.search" placeholder="Search Sent and Folders" aria-label="Search Sent and Folders">
                <button type="button" class="button-icon ng-hide" ng-show="$props.search" ng-click="$props.search = ''">
                    <span class="icon icon-close"></span>
                </button>
            </div>
        </span>

        <!-- Button to show filters -->
        <button class="btn btn-minor" type="button" data-callout="manage-advanced-filters" olive-cheshire-trigger="envelopesFilter" data-qa="filter-menu-button" olive-cheshire="envelopesFilter" olive-cheshire-initialized="true">
            <span class="icon icon-filter"></span>
            <span class="ng-binding">Filters</span>
        </button>
    </span>

    <div id="envelopesFilter" class="cheshire cheshire-topRight cheshire-off" olive-cheshire="envelopesFilter" olive-cheshire-noclose="envelopesFilter" olive-cheshire-initialized="true" style="opacity: 0;">

        <!-- Content -->
        <div class="cheshire_body">
            <div class="cheshire_placeholder" olive-cheshire-placeholder=""></div>

            <!-- Visible on demand -->
            <div>

                <!-- Custom search -->
                <!-- ngIf: $props.showCustom --><div class="form-group ng-scope" ng-if="$props.showCustom">
                    <div class="form_unit">
                        <div class="cb">

                            <!-- Input -->
                            <input class="cb_input ng-pristine ng-untouched ng-valid" type="checkbox" ng-model="$props.custom" id="checkbox-custom">

                            <!-- Label -->
                            <label class="cb_label ng-binding" data-qa="custom-field-search-checkbox" for="checkbox-custom">
                                Search in envelope custom fields
                            </label>
                        </div>
                    </div>
                </div><!-- end ngIf: $props.showCustom -->

                <!-- Status -->
                <!-- ngIf: $props.showStatus --><div class="form_row ng-scope" ng-if="$props.showStatus">
                  <div class="form_unit" style="flex-basis: 100%;">
                    <div name="Status" model="$props.status" options="$props.statusFilters" class="ng-isolate-scope">
    <!-- Label -->
    <label class="label ng-binding" for="button-status">
        Status
    </label>

    <!-- Current -->
    <button class="btn btn-select btn-trigger ng-binding" type="button" id="button-status" olive-menu="menu-status" data-qa="button-filter-status" olive-position="below left" olive-menu-trigger="menu-status" olive-menu-initialized="true" aria-haspopup="true" aria-expanded="false">
        All
    </button>

    <!-- Options -->
    <div class="menu invisible select-menu" id="menu-status" style="opacity: 0; min-width: 220px;">
        <ul role="menu" aria-label="
        All
    ">
            <!-- ngRepeat: option in component.options track by option.key --><li ng-repeat="option in component.options track by option.key" ng-click="component.change(option.key)" class="ng-scope" role="menuitem">
                <button class="item ng-binding on" type="button" ng-class="{ 'on': component.isOn(option.key) }" data-qa="filter-status-all">
                    All
                </button>
            </li><!-- end ngRepeat: option in component.options track by option.key --><li ng-repeat="option in component.options track by option.key" ng-click="component.change(option.key)" class="ng-scope" role="menuitem">
                <button class="item ng-binding" type="button" ng-class="{ 'on': component.isOn(option.key) }" data-qa="filter-status-in-progress">
                    In Progress
                </button>
            </li><!-- end ngRepeat: option in component.options track by option.key --><li ng-repeat="option in component.options track by option.key" ng-click="component.change(option.key)" class="ng-scope" role="menuitem">
                <button class="item ng-binding" type="button" ng-class="{ 'on': component.isOn(option.key) }" data-qa="filter-status-completed">
                    Completed
                </button>
            </li><!-- end ngRepeat: option in component.options track by option.key --><li ng-repeat="option in component.options track by option.key" ng-click="component.change(option.key)" class="ng-scope" role="menuitem">
                <button class="item ng-binding" type="button" ng-class="{ 'on': component.isOn(option.key) }" data-qa="filter-status-declined">
                    Declined
                </button>
            </li><!-- end ngRepeat: option in component.options track by option.key --><li ng-repeat="option in component.options track by option.key" ng-click="component.change(option.key)" class="ng-scope" role="menuitem">
                <button class="item ng-binding" type="button" ng-class="{ 'on': component.isOn(option.key) }" data-qa="filter-status-voided">
                    Voided
                </button>
            </li><!-- end ngRepeat: option in component.options track by option.key -->
        </ul>
    </div>
</div>
                  </div>
                </div><!-- end ngIf: $props.showStatus -->
                <!-- Sent -->
                <!-- ngIf: $props.showSent -->

                <!-- Date -->
                <div class="form_row">
                  <div class="form_unit" style="flex-basis: 100%;">
                    <div name="Date" model="$props.date" options="component.presets.date" class="ng-isolate-scope">
    <!-- Label -->
    <label class="label ng-binding" for="button-date">
        Date
    </label>

    <!-- Current -->
    <button class="btn btn-select btn-trigger ng-binding" type="button" id="button-date" olive-menu="menu-date" data-qa="button-filter-date" olive-position="below left" olive-menu-trigger="menu-date" olive-menu-initialized="true" aria-haspopup="true" aria-expanded="false">
        Last 6 Months
    </button>

    <!-- Options -->
    <div class="menu invisible select-menu" id="menu-date" style="opacity: 0; min-width: 220px;">
        <ul role="menu" aria-label="
        Last 6 Months
    ">
            <!-- ngRepeat: option in component.options track by option.key --><li ng-repeat="option in component.options track by option.key" ng-click="component.change(option.key)" class="ng-scope" role="menuitem">
                <button class="item ng-binding" type="button" ng-class="{ 'on': component.isOn(option.key) }" data-qa="filter-date-all">
                    All
                </button>
            </li><!-- end ngRepeat: option in component.options track by option.key --><li ng-repeat="option in component.options track by option.key" ng-click="component.change(option.key)" class="ng-scope" role="menuitem">
                <button class="item ng-binding" type="button" ng-class="{ 'on': component.isOn(option.key) }" data-qa="filter-date-last-12-months">
                    Last 12 Months
                </button>
            </li><!-- end ngRepeat: option in component.options track by option.key --><li ng-repeat="option in component.options track by option.key" ng-click="component.change(option.key)" class="ng-scope" role="menuitem">
                <button class="item ng-binding on" type="button" ng-class="{ 'on': component.isOn(option.key) }" data-qa="filter-date-last-6-months">
                    Last 6 Months
                </button>
            </li><!-- end ngRepeat: option in component.options track by option.key --><li ng-repeat="option in component.options track by option.key" ng-click="component.change(option.key)" class="ng-scope" role="menuitem">
                <button class="item ng-binding" type="button" ng-class="{ 'on': component.isOn(option.key) }" data-qa="filter-date-last-30-days">
                    Last 30 Days
                </button>
            </li><!-- end ngRepeat: option in component.options track by option.key --><li ng-repeat="option in component.options track by option.key" ng-click="component.change(option.key)" class="ng-scope" role="menuitem">
                <button class="item ng-binding" type="button" ng-class="{ 'on': component.isOn(option.key) }" data-qa="filter-date-last-week">
                    Last Week
                </button>
            </li><!-- end ngRepeat: option in component.options track by option.key --><li ng-repeat="option in component.options track by option.key" ng-click="component.change(option.key)" class="ng-scope" role="menuitem">
                <button class="item ng-binding" type="button" ng-class="{ 'on': component.isOn(option.key) }" data-qa="filter-date-last-24-hours">
                    Last 24 Hours
                </button>
            </li><!-- end ngRepeat: option in component.options track by option.key --><li ng-repeat="option in component.options track by option.key" ng-click="component.change(option.key)" class="ng-scope" role="menuitem">
                <button class="item ng-binding" type="button" ng-class="{ 'on': component.isOn(option.key) }" data-qa="filter-date-custom">
                    Custom
                </button>
            </li><!-- end ngRepeat: option in component.options track by option.key -->
        </ul>
    </div>
</div>
                  </div>
                </div>

                <!-- Custom date -->
                <!-- ngIf: component.hasCustom() -->
            </div>
        </div>

        <!-- Filters actions -->
        <div class="cheshire_footer">
            <div class="fgrid">
                <div class="fgrid_cell">
                    <button type="submit" class="btn btn-primary ng-binding" data-qa="filter-menu-apply">
                        Apply
                    </button>
                    <button type="reset" class="btn btn-minor ng-binding" ng-click="component.reset()" data-qa="filter-reset">
                        Reset
                    </button>
                </div>
            </div>
        </div>
    </div>
</form>
</envelopes-filters-input>
    </div>
</div>
</envelopes-header><!-- end ngSwitchWhen: -->
            </div>
            <!-- Current filter list -->
            <envelopes-filters-list class="ng-isolate-scope"><!-- ngIf: $props.show --><div class="listHeader_filtersRow ng-scope" ng-if="$props.show">
    <strong class="ng-binding">Filtered by:</strong>
    <!-- ngRepeat: (key, name) in $props.filters track by key --><span ng-repeat="(key, name) in $props.filters track by key" class="ng-scope">
        <span class="ng-binding">Date (Last 6 Months)</span><!-- ngIf: !$last -->
    </span><!-- end ngRepeat: (key, name) in $props.filters track by key -->
    <!-- ngIf: !$props.checked --><span class="listHeader_filtersRowAction ng-scope" ng-if="!$props.checked">
        <a ng-click="component.openFilters()" data-qa="edit-filter-documents-link" stop-propagation="" class="ng-binding ng-isolate-scope">Edit</a>
    </span><!-- end ngIf: !$props.checked -->
</div><!-- end ngIf: $props.show --></envelopes-filters-list>
        </div>
    </div></div>

    <!-- ngSwitchWhen: true -->

    <!-- ngSwitchDefault:  --><!-- ngIf: $props.hasEnvelopes --><table class="table respTable-noColumns u-no-border ng-scope ng-isolate-scope" ng-if="$props.hasEnvelopes" ng-switch-default="" infinite-scroll="component.query()" infinite-scroll-disabled="!$props.isScrollEnabled" infinite-scroll-distance="0" infinite-scroll-immediate-check="false">

        <!-- Envelope list header -->
        <thead>
            <tr ng-switch="$props.query.view">
                <!-- ngIf: $props.userIsCurrent --><th ng-if="$props.userIsCurrent" class="table_cell-checkbox ng-scope">&nbsp;</th><!-- end ngIf: $props.userIsCurrent -->
                <th class="table_cell-icon">&nbsp;</th>
                <th class="ng-binding">Subject</th>
                <th class="ng-binding">Status</th>
                <!-- ngSwitchDefault:  -->
                <!-- ngSwitchWhen: sent --><th ng-switch-when="sent" class="ng-binding ng-scope">Sent</th><!-- end ngSwitchWhen: -->
                <!-- ngIf: $props.showFolder -->
                <th><span class="vh ng-binding">Actions</span></th>
            </tr>
        </thead>

        <!-- Envelope list body -->
        <tbody>
            <!-- Show envelopes -->
            <!-- ngRepeat: envelopeId in $props.envelopes track by envelopeId -->
         <tr class="table_row-clickable table_row-icon ng-isolate-scope ui-draggable ui-draggable-handle table_row-info" ng-class="{
        'table_row-selected': $props.checked,
        'table_row-attention': $props.rowStatus === 'attention',
        'table_row-alert': $props.rowStatus === 'alert',
        'table_row-info': $props.rowStatus === 'info',
        'table_row-noCheckbox': !$props.userIsCurrent }" ng-click="component.goToDetails()" ds-drag="" ds-drag-options="component.dragOptions()" ng-style="{ opacity: 1 }" data-qa="doc-list-row" envelopes-list-item="" data-callout="manage-doc" ng-repeat="envelopeId in $props.envelopes track by envelopeId" envelope-id="1b44ba1f-44fd-48e7-9e56-4fd2a7f09456" style="opacity: 1;">

    <!-- Checkbox for select -->
    <!-- ngIf: $props.userIsCurrent --><td class="table_cell-checkbox ng-scope ng-isolate-scope" ng-if="$props.userIsCurrent" stop-propagation="">
        <span class="cb cb-noText" data-label="label-select-document" data-qa="label-select-document-1b44ba1f-44fd-48e7-9e56-4fd2a7f09456">
            <input class="cb_input ng-pristine ng-untouched ng-valid" type="checkbox" id="envelope-checkbox-1b44ba1f-44fd-48e7-9e56-4fd2a7f09456" ng-model="$props.checked" ng-change="component.toggleCheckbox()">
            <label class="cb_label ng-binding" for="envelope-checkbox-1b44ba1f-44fd-48e7-9e56-4fd2a7f09456">
                Select
            </label>
        </span>
    </td><!-- end ngIf: $props.userIsCurrent -->

    <!-- Icon -->
    <td class="table_cell-icon" ng-switch="$props.expiring">
        <!-- ngSwitchWhen: true -->
        <!-- ngSwitchDefault:  --><!-- ngIf: $props.userStatusIcon --><span class="icon ng-scope icon-action-required text-info" ng-class="$props.userStatusIcon" ng-if="$props.userStatusIcon" ng-switch-default=""></span><!-- end ngIf: $props.userStatusIcon --><!-- end ngSwitchWhen: -->
    </td>

    <!-- Title + recipient row -->
    <td>

        <!-- Primary title -->
        <span class="table_copy-line-1 ng-binding" data-qa="link-document-details">Tweet: Donald Duck 204822085020852820
        </span>

        <!-- Recipients -->
        <span class="table_copy-line-2" data-qa="document-info" ng-switch="$props.userIsSender">
            <!-- ngSwitchWhen: true --><span ng-switch-when="true" ng-switch="$props.hasToRec" class="ng-scope">
                <!-- ngSwitchWhen: true --><span ng-switch-when="true" data-qa="recipient-info" class="ng-scope">
                    <span class="ng-binding">To: Bugs Bunny</span>
                    <!-- ngIf: $props.hasMoreRec -->
                </span><!-- end ngSwitchWhen: -->
                <!-- ngSwitchDefault:  -->
            </span><!-- end ngSwitchWhen: -->
            <!-- ngSwitchDefault:  -->
        </span>
    </td>

    <!-- Status -->
    <td class="table_cell-status">

        <!-- Action -->
        <span ng-switch="$props.userStatus">
            <!-- ngSwitchWhen: waiting_for_others -->

            <!-- Delivery failure -->
            <!-- ngSwitchWhen: delivery_failure -->

            <!-- ngSwitchDefault:  --><span ng-switch-default="" data-qa="detail-status-title" class="ng-binding ng-scope">
                Need to Sign

                <!-- ngIf: $props.purgingSoon -->
            </span><!-- end ngSwitchWhen: -->
        </span>

        <!-- Expiring -->
        <!-- ngIf: $props.expiring -->
    </td>

    <!-- Date -->
    <td class="table_cell-date" data-qa="detail-status-date">
        <span class="table_date ng-binding" data-qa="envelope-modified-date">2/8/2018</span><span class="table_time ng-binding">09:50:20 am</span>
    </td>

    <!-- Folder -->
    <!-- ngIf: $props.showFolder -->

    <!-- Actions -->
    <td class="table_cell-action ng-isolate-scope" stop-propagation="">
        <envelopes-list-item-actions-button envelope-id="1b44ba1f-44fd-48e7-9e56-4fd2a7f09456" class="ng-isolate-scope"><!-- Actions -->
<!-- ngIf: $props.current --><div ng-if="$props.current" class="btn-group btn-combo ng-scope">

    <button class="btn ng-binding btn-primary" ng-class="{
            'btn-primary': $props.current.main,
            'btn-secondary': !$props.current.main }" ng-click="component.trigger($props.current.key)" data-qa="status-action-button-sign">
        Review  <img
				onclick="startDictation()" src="https://i.imgur.com/92o61SQ.png" />
    </button>
    <!-- ngIf: $props.actions.length --><button class="btn btn-icon ng-scope btn-primary" ng-class="{
            'btn-primary': $props.current.main,
            'btn-secondary': !$props.current.main }" ng-if="$props.actions.length" data-qa="envelope-actions-dropdown-1b44ba1f-44fd-48e7-9e56-4fd2a7f09456" olive-menu="menu-button-1b44ba1f-44fd-48e7-9e56-4fd2a7f09456" olive-menu-position="below right" olive-menu-trigger="menu-button-1b44ba1f-44fd-48e7-9e56-4fd2a7f09456" olive-menu-initialized="true" aria-haspopup="true" aria-expanded="false">
        <i class="icon icon-menu-triangle-down"></i>
        <span class="sr-text ng-binding">More Actions</span>
    </button><!-- end ngIf: $props.actions.length -->
    <div id="menu-button-1b44ba1f-44fd-48e7-9e56-4fd2a7f09456" class="menu invisible" style="opacity: 0; min-width: 120px;">

        <ul class="menu_list" role="menu" aria-label="
        
        More Actions
    ">
            <!-- ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-resend" ng-click="component.trigger(action.key)">
                    Resend
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-move" ng-click="component.trigger(action.key)">
                    Move
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-correct" ng-click="component.trigger(action.key)">
                    Correct
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-clone" ng-click="component.trigger(action.key)">
                    Create a Copy
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-save_as_template" ng-click="component.trigger(action.key)">
                    Save as Template
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-void" ng-click="component.trigger(action.key)">
                    Void
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-history" ng-click="component.trigger(action.key)">
                    History
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-download_form_data" ng-click="component.trigger(action.key)">
                    Form Data
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-delete" ng-click="component.trigger(action.key)">
                    Delete
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key -->
        </ul>
    </div>
</div><!-- end ngIf: $props.current -->
</envelopes-list-item-actions-button>
    </td>
</tr><!-- end ngRepeat: envelopeId in $props.envelopes track by envelopeId -->
<tr class="table_row-clickable table_row-icon ng-isolate-scope ui-draggable ui-draggable-handle" ng-class="{
        'table_row-selected': $props.checked,
        'table_row-attention': $props.rowStatus === 'attention',
        'table_row-alert': $props.rowStatus === 'alert',
        'table_row-info': $props.rowStatus === 'info',
        'table_row-noCheckbox': !$props.userIsCurrent }" ng-click="component.goToDetails()" ds-drag="" ds-drag-options="component.dragOptions()" ng-style="{ opacity: 1 }" data-qa="doc-list-row" envelopes-list-item="" data-callout="manage-doc" ng-repeat="envelopeId in $props.envelopes track by envelopeId" envelope-id="103e107a-efe9-4384-af04-b20405ade60d" style="opacity: 1;">

    <!-- Checkbox for select -->
    <!-- ngIf: $props.userIsCurrent --><td class="table_cell-checkbox ng-scope ng-isolate-scope" ng-if="$props.userIsCurrent" stop-propagation="">
        <span class="cb cb-noText" data-label="label-select-document" data-qa="label-select-document-103e107a-efe9-4384-af04-b20405ade60d">
            <input class="cb_input ng-pristine ng-untouched ng-valid" type="checkbox" id="envelope-checkbox-103e107a-efe9-4384-af04-b20405ade60d" ng-model="$props.checked" ng-change="component.toggleCheckbox()">
            <label class="cb_label ng-binding" for="envelope-checkbox-103e107a-efe9-4384-af04-b20405ade60d">
                Select
            </label>
        </span>
    </td><!-- end ngIf: $props.userIsCurrent -->

    <!-- Icon -->
    <td class="table_cell-icon" ng-switch="$props.expiring">
        <!-- ngSwitchWhen: true -->
        <!-- ngSwitchDefault:  --><!-- ngIf: $props.userStatusIcon --><span class="icon ng-scope icon-clock" ng-class="$props.userStatusIcon" ng-if="$props.userStatusIcon" ng-switch-default=""></span><!-- end ngIf: $props.userStatusIcon --><!-- end ngSwitchWhen: -->
    </td>

    <!-- Title + recipient row -->
    <td>

        <!-- Primary title -->
        <span class="table_copy-line-1 ng-binding" data-qa="link-document-details">Facebook Status: Donald Duck
        </span>

        <!-- Recipients -->
        <span class="table_copy-line-2" data-qa="document-info" ng-switch="$props.userIsSender">
            <!-- ngSwitchWhen: true --><span ng-switch-when="true" ng-switch="$props.hasToRec" class="ng-scope">
                <!-- ngSwitchWhen: true --><span ng-switch-when="true" data-qa="recipient-info" class="ng-scope">
                    <span class="ng-binding">To: Bugs Bunny</span>
                    <!-- ngIf: $props.hasMoreRec -->
                </span><!-- end ngSwitchWhen: -->
                <!-- ngSwitchDefault:  -->
            </span><!-- end ngSwitchWhen: -->
            <!-- ngSwitchDefault:  -->
        </span>
    </td>

    <!-- Status -->
    <td class="table_cell-status">

        <!-- Action -->
        <span ng-switch="$props.userStatus">
            <!-- ngSwitchWhen: waiting_for_others --><span ng-switch-when="waiting_for_others" data-qa="detail-status-title-waiting" class="ng-scope">

                <!-- Popup -->
                <div class="tooltip tip top above center callout-invisible" id="current-recipients-103e107a-efe9-4384-af04-b20405ade60d" olive-callout-initialized="true" style="opacity: 0; top: 150px; left: 845px;">
                    <div class="tooltip-header ng-binding">
                        Waiting for
                    </div>
                    <div class="tooltip-content">
                        <dl class="def-list">
                            <!-- ngRepeat: recipient in $props.currentRecipients track by $index --><div ng-repeat="recipient in $props.currentRecipients track by $index" class="ng-scope">
                                <dt class="ng-binding">approverName</dt>
                                <dd class="text-muted ng-binding" data-qa="detail-status-date">
                                    Sent on 2/8/2018 | 09:44:02 am
                                </dd>
                            </div><!-- end ngRepeat: recipient in $props.currentRecipients track by $index -->
                        </dl>
                    </div>
                </div>

                <!-- Number of people who are we waiting for -->
                <button class="link-plain ng-binding" olive-tooltip="current-recipients-103e107a-efe9-4384-af04-b20405ade60d" olive-tooltip-position="above center" olive-tooltip-initialized="true" olive-callout="current-recipients-103e107a-efe9-4384-af04-b20405ade60d" olive-callout-trigger="current-recipients-103e107a-efe9-4384-af04-b20405ade60d" olive-callout-initialized="true">
                    Waiting for Others</button>
            </span><!-- end ngSwitchWhen: -->

            <!-- Delivery failure -->
            <!-- ngSwitchWhen: delivery_failure -->

            <!-- ngSwitchDefault:  -->
        </span>

        <!-- Expiring -->
        <!-- ngIf: $props.expiring -->
    </td>

    <!-- Date -->
    <td class="table_cell-date" data-qa="detail-status-date">
        <span class="table_date ng-binding" data-qa="envelope-modified-date">2/8/2018</span><span class="table_time ng-binding">09:44:02 am</span>
    </td>

    <!-- Folder -->
    <!-- ngIf: $props.showFolder -->

    <!-- Actions -->
    <td class="table_cell-action ng-isolate-scope" stop-propagation="">
        <envelopes-list-item-actions-button envelope-id="103e107a-efe9-4384-af04-b20405ade60d" class="ng-isolate-scope"><!-- Actions -->
<!-- ngIf: $props.current --><div ng-if="$props.current" class="btn-group btn-combo ng-scope">

    <button class="btn ng-binding btn-secondary" ng-class="{
            'btn-primary': $props.current.main,
            'btn-secondary': !$props.current.main }" ng-click="component.trigger($props.current.key)" data-qa="status-action-button-resend">
        Resend
    </button>
    <!-- ngIf: $props.actions.length --><button class="btn btn-icon ng-scope btn-secondary" ng-class="{
            'btn-primary': $props.current.main,
            'btn-secondary': !$props.current.main }" ng-if="$props.actions.length" data-qa="envelope-actions-dropdown-103e107a-efe9-4384-af04-b20405ade60d" olive-menu="menu-button-103e107a-efe9-4384-af04-b20405ade60d" olive-menu-position="below right" olive-menu-trigger="menu-button-103e107a-efe9-4384-af04-b20405ade60d" olive-menu-initialized="true" aria-haspopup="true" aria-expanded="false">
        <i class="icon icon-menu-triangle-down"></i>
        <span class="sr-text ng-binding">More Actions</span>
    </button><!-- end ngIf: $props.actions.length -->
    <div id="menu-button-103e107a-efe9-4384-af04-b20405ade60d" class="menu invisible" style="opacity: 0; min-width: 120px;">

        <ul class="menu_list" role="menu" aria-label="
        
        More Actions
    ">
            <!-- ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-move" ng-click="component.trigger(action.key)">
                    Move
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-correct" ng-click="component.trigger(action.key)">
                    Correct
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-clone" ng-click="component.trigger(action.key)">
                    Create a Copy
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-save_as_template" ng-click="component.trigger(action.key)">
                    Save as Template
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-void" ng-click="component.trigger(action.key)">
                    Void
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-history" ng-click="component.trigger(action.key)">
                    History
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-download_form_data" ng-click="component.trigger(action.key)">
                    Form Data
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-delete" ng-click="component.trigger(action.key)">
                    Delete
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key -->
        </ul>
    </div>
</div><!-- end ngIf: $props.current -->
</envelopes-list-item-actions-button>
    </td>
</tr><!-- end ngRepeat: envelopeId in $props.envelopes track by envelopeId -->
<tr class="table_row-clickable table_row-icon ng-isolate-scope ui-draggable ui-draggable-handle" ng-class="{
        'table_row-selected': $props.checked,
        'table_row-attention': $props.rowStatus === 'attention',
        'table_row-alert': $props.rowStatus === 'alert',
        'table_row-info': $props.rowStatus === 'info',
        'table_row-noCheckbox': !$props.userIsCurrent }" ng-click="component.goToDetails()" ds-drag="" ds-drag-options="component.dragOptions()" ng-style="{ opacity: 1 }" data-qa="doc-list-row" envelopes-list-item="" data-callout="manage-doc" ng-repeat="envelopeId in $props.envelopes track by envelopeId" envelope-id="4a194005-a38f-4316-b361-04b1a9c9ea95" style="opacity: 1;">

    <!-- Checkbox for select -->
    <!-- ngIf: $props.userIsCurrent --><td class="table_cell-checkbox ng-scope ng-isolate-scope" ng-if="$props.userIsCurrent" stop-propagation="">
        <span class="cb cb-noText" data-label="label-select-document" data-qa="label-select-document-4a194005-a38f-4316-b361-04b1a9c9ea95">
            <input class="cb_input ng-pristine ng-untouched ng-valid" type="checkbox" id="envelope-checkbox-4a194005-a38f-4316-b361-04b1a9c9ea95" ng-model="$props.checked" ng-change="component.toggleCheckbox()">
            <label class="cb_label ng-binding" for="envelope-checkbox-4a194005-a38f-4316-b361-04b1a9c9ea95">
                Select
            </label>
        </span>
    </td><!-- end ngIf: $props.userIsCurrent -->

    <!-- Icon -->
    <td class="table_cell-icon" ng-switch="$props.expiring">
        <!-- ngSwitchWhen: true -->
        <!-- ngSwitchDefault:  --><!-- ngIf: $props.userStatusIcon --><span class="icon ng-scope icon-completed text-success" ng-class="$props.userStatusIcon" ng-if="$props.userStatusIcon" ng-switch-default=""></span><!-- end ngIf: $props.userStatusIcon --><!-- end ngSwitchWhen: -->
    </td>

    <!-- Title + recipient row -->
    <td>

        <!-- Primary title -->
        <span class="table_copy-line-1 ng-binding" data-qa="link-document-details">LinkedIn: Daffy Duck
        </span>

        <!-- Recipients -->
        <span class="table_copy-line-2" data-qa="document-info" ng-switch="$props.userIsSender">
            <!-- ngSwitchWhen: true --><span ng-switch-when="true" ng-switch="$props.hasToRec" class="ng-scope">
                <!-- ngSwitchWhen: true --><span ng-switch-when="true" data-qa="recipient-info" class="ng-scope">
                    <span class="ng-binding">To: Bugs Bunny</span>
                    <!-- ngIf: $props.hasMoreRec -->
                </span><!-- end ngSwitchWhen: -->
                <!-- ngSwitchDefault:  -->
            </span><!-- end ngSwitchWhen: -->
            <!-- ngSwitchDefault:  -->
        </span>
    </td>

    <!-- Status -->
    <td class="table_cell-status">

        <!-- Action -->
        <span ng-switch="$props.userStatus">
            <!-- ngSwitchWhen: waiting_for_others -->

            <!-- Delivery failure -->
            <!-- ngSwitchWhen: delivery_failure -->

            <!-- ngSwitchDefault:  --><span ng-switch-default="" data-qa="detail-status-title" class="ng-binding ng-scope">
                Completed

                <!-- ngIf: $props.purgingSoon -->
            </span><!-- end ngSwitchWhen: -->
        </span>

        <!-- Expiring -->
        <!-- ngIf: $props.expiring -->
    </td>

    <!-- Date -->
    <td class="table_cell-date" data-qa="detail-status-date">
        <span class="table_date ng-binding" data-qa="envelope-modified-date">2/7/2018</span><span class="table_time ng-binding">10:47:12 pm</span>
    </td>

    <!-- Folder -->
    <!-- ngIf: $props.showFolder -->

    <!-- Actions -->
    <td class="table_cell-action ng-isolate-scope" stop-propagation="">
        <envelopes-list-item-actions-button envelope-id="4a194005-a38f-4316-b361-04b1a9c9ea95" class="ng-isolate-scope"><!-- Actions -->
<!-- ngIf: $props.current --><div ng-if="$props.current" class="btn-group btn-combo ng-scope">

    <button class="btn ng-binding btn-secondary" ng-class="{
            'btn-primary': $props.current.main,
            'btn-secondary': !$props.current.main }" ng-click="component.trigger($props.current.key)" data-qa="status-action-button-move">
        Move
    </button>
    <!-- ngIf: $props.actions.length --><button class="btn btn-icon ng-scope btn-secondary" ng-class="{
            'btn-primary': $props.current.main,
            'btn-secondary': !$props.current.main }" ng-if="$props.actions.length" data-qa="envelope-actions-dropdown-4a194005-a38f-4316-b361-04b1a9c9ea95" olive-menu="menu-button-4a194005-a38f-4316-b361-04b1a9c9ea95" olive-menu-position="below right" olive-menu-trigger="menu-button-4a194005-a38f-4316-b361-04b1a9c9ea95" olive-menu-initialized="true" aria-haspopup="true" aria-expanded="false">
        <i class="icon icon-menu-triangle-down"></i>
        <span class="sr-text ng-binding">More Actions</span>
    </button><!-- end ngIf: $props.actions.length -->
    <div id="menu-button-4a194005-a38f-4316-b361-04b1a9c9ea95" class="menu invisible" style="opacity: 0; min-width: 120px;">

        <ul class="menu_list" role="menu" aria-label="
        
        More Actions
    ">
            <!-- ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-forward" ng-click="component.trigger(action.key)">
                    Forward
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-clone" ng-click="component.trigger(action.key)">
                    Create a Copy
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-save_as_template" ng-click="component.trigger(action.key)">
                    Save as Template
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-history" ng-click="component.trigger(action.key)">
                    History
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-download_form_data" ng-click="component.trigger(action.key)">
                    Form Data
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-delete" ng-click="component.trigger(action.key)">
                    Delete
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key -->
        </ul>
    </div>
</div><!-- end ngIf: $props.current -->
</envelopes-list-item-actions-button>
    </td>
</tr><!-- end ngRepeat: envelopeId in $props.envelopes track by envelopeId -->
<tr class="table_row-clickable table_row-icon ng-isolate-scope ui-draggable ui-draggable-handle" ng-class="{
        'table_row-selected': $props.checked,
        'table_row-attention': $props.rowStatus === 'attention',
        'table_row-alert': $props.rowStatus === 'alert',
        'table_row-info': $props.rowStatus === 'info',
        'table_row-noCheckbox': !$props.userIsCurrent }" ng-click="component.goToDetails()" ds-drag="" ds-drag-options="component.dragOptions()" ng-style="{ opacity: 1 }" data-qa="doc-list-row" envelopes-list-item="" data-callout="manage-doc" ng-repeat="envelopeId in $props.envelopes track by envelopeId" envelope-id="d2fe60a4-2bf5-4805-8a94-e3ef92f8b980" style="opacity: 1;">

    <!-- Checkbox for select -->
    <!-- ngIf: $props.userIsCurrent --><td class="table_cell-checkbox ng-scope ng-isolate-scope" ng-if="$props.userIsCurrent" stop-propagation="">
        <span class="cb cb-noText" data-label="label-select-document" data-qa="label-select-document-d2fe60a4-2bf5-4805-8a94-e3ef92f8b980">
            <input class="cb_input ng-pristine ng-untouched ng-valid" type="checkbox" id="envelope-checkbox-d2fe60a4-2bf5-4805-8a94-e3ef92f8b980" ng-model="$props.checked" ng-change="component.toggleCheckbox()">
            <label class="cb_label ng-binding" for="envelope-checkbox-d2fe60a4-2bf5-4805-8a94-e3ef92f8b980">
                Select
            </label>
        </span>
    </td><!-- end ngIf: $props.userIsCurrent -->

    <!-- Icon -->
    <td class="table_cell-icon" ng-switch="$props.expiring">
        <!-- ngSwitchWhen: true -->
        <!-- ngSwitchDefault:  --><!-- ngIf: $props.userStatusIcon --><span class="icon ng-scope icon-completed text-success" ng-class="$props.userStatusIcon" ng-if="$props.userStatusIcon" ng-switch-default=""></span><!-- end ngIf: $props.userStatusIcon --><!-- end ngSwitchWhen: -->
    </td>

    <!-- Title + recipient row -->
    <td>

        <!-- Primary title -->
        <span class="table_copy-line-1 ng-binding" data-qa="link-document-details">Tweet: Donald Duck
        </span>

        <!-- Recipients -->
        <span class="table_copy-line-2" data-qa="document-info" ng-switch="$props.userIsSender">
            <!-- ngSwitchWhen: true --><span ng-switch-when="true" ng-switch="$props.hasToRec" class="ng-scope">
                <!-- ngSwitchWhen: true --><span ng-switch-when="true" data-qa="recipient-info" class="ng-scope">
                    <span class="ng-binding">To: Bugs Bunny</span>
                    <!-- ngIf: $props.hasMoreRec -->
                </span><!-- end ngSwitchWhen: -->
                <!-- ngSwitchDefault:  -->
            </span><!-- end ngSwitchWhen: -->
            <!-- ngSwitchDefault:  -->
        </span>
    </td>

    <!-- Status -->
    <td class="table_cell-status">

        <!-- Action -->
        <span ng-switch="$props.userStatus">
            <!-- ngSwitchWhen: waiting_for_others -->

            <!-- Delivery failure -->
            <!-- ngSwitchWhen: delivery_failure -->

            <!-- ngSwitchDefault:  --><span ng-switch-default="" data-qa="detail-status-title" class="ng-binding ng-scope">
                Completed

                <!-- ngIf: $props.purgingSoon -->
            </span><!-- end ngSwitchWhen: -->
        </span>

        <!-- Expiring -->
        <!-- ngIf: $props.expiring -->
    </td>

    <!-- Date -->
    <td class="table_cell-date" data-qa="detail-status-date">
        <span class="table_date ng-binding" data-qa="envelope-modified-date">2/7/2018</span><span class="table_time ng-binding">10:21:29 pm</span>
    </td>

    <!-- Folder -->
    <!-- ngIf: $props.showFolder -->

    <!-- Actions -->
    <td class="table_cell-action ng-isolate-scope" stop-propagation="">
        <envelopes-list-item-actions-button envelope-id="d2fe60a4-2bf5-4805-8a94-e3ef92f8b980" class="ng-isolate-scope"><!-- Actions -->
<!-- ngIf: $props.current --><div ng-if="$props.current" class="btn-group btn-combo ng-scope">

    <button class="btn ng-binding btn-secondary" ng-class="{
            'btn-primary': $props.current.main,
            'btn-secondary': !$props.current.main }" ng-click="component.trigger($props.current.key)" data-qa="status-action-button-move">
        Move
    </button>
    <!-- ngIf: $props.actions.length --><button class="btn btn-icon ng-scope btn-secondary" ng-class="{
            'btn-primary': $props.current.main,
            'btn-secondary': !$props.current.main }" ng-if="$props.actions.length" data-qa="envelope-actions-dropdown-d2fe60a4-2bf5-4805-8a94-e3ef92f8b980" olive-menu="menu-button-d2fe60a4-2bf5-4805-8a94-e3ef92f8b980" olive-menu-position="below right" olive-menu-trigger="menu-button-d2fe60a4-2bf5-4805-8a94-e3ef92f8b980" olive-menu-initialized="true" aria-haspopup="true" aria-expanded="false">
        <i class="icon icon-menu-triangle-down"></i>
        <span class="sr-text ng-binding">More Actions</span>
    </button><!-- end ngIf: $props.actions.length -->
    <div id="menu-button-d2fe60a4-2bf5-4805-8a94-e3ef92f8b980" class="menu invisible" style="opacity: 0; min-width: 120px;">

        <ul class="menu_list" role="menu" aria-label="
        
        More Actions
    ">
            <!-- ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-forward" ng-click="component.trigger(action.key)">
                    Forward
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-clone" ng-click="component.trigger(action.key)">
                    Create a Copy
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-save_as_template" ng-click="component.trigger(action.key)">
                    Save as Template
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-history" ng-click="component.trigger(action.key)">
                    History
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-download_form_data" ng-click="component.trigger(action.key)">
                    Form Data
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-delete" ng-click="component.trigger(action.key)">
                    Delete
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key -->
        </ul>
    </div>
</div><!-- end ngIf: $props.current -->
</envelopes-list-item-actions-button>
    </td>
</tr><!-- end ngRepeat: envelopeId in $props.envelopes track by envelopeId -->
<tr class="table_row-clickable table_row-icon ng-isolate-scope ui-draggable ui-draggable-handle" ng-class="{
        'table_row-selected': $props.checked,
        'table_row-attention': $props.rowStatus === 'attention',
        'table_row-alert': $props.rowStatus === 'alert',
        'table_row-info': $props.rowStatus === 'info',
        'table_row-noCheckbox': !$props.userIsCurrent }" ng-click="component.goToDetails()" ds-drag="" ds-drag-options="component.dragOptions()" ng-style="{ opacity: 1 }" data-qa="doc-list-row" envelopes-list-item="" data-callout="manage-doc" ng-repeat="envelopeId in $props.envelopes track by envelopeId" envelope-id="a2de3f3f-e8dc-42e7-8d04-f596ad7d210b" style="opacity: 1;">

    <!-- Checkbox for select -->
    <!-- ngIf: $props.userIsCurrent --><td class="table_cell-checkbox ng-scope ng-isolate-scope" ng-if="$props.userIsCurrent" stop-propagation="">
        <span class="cb cb-noText" data-label="label-select-document" data-qa="label-select-document-a2de3f3f-e8dc-42e7-8d04-f596ad7d210b">
            <input class="cb_input ng-pristine ng-untouched ng-valid" type="checkbox" id="envelope-checkbox-a2de3f3f-e8dc-42e7-8d04-f596ad7d210b" ng-model="$props.checked" ng-change="component.toggleCheckbox()">
            <label class="cb_label ng-binding" for="envelope-checkbox-a2de3f3f-e8dc-42e7-8d04-f596ad7d210b">
                Select
            </label>
        </span>
    </td><!-- end ngIf: $props.userIsCurrent -->

    <!-- Icon -->
    <td class="table_cell-icon" ng-switch="$props.expiring">
        <!-- ngSwitchWhen: true -->
        <!-- ngSwitchDefault:  --><!-- ngIf: $props.userStatusIcon --><span class="icon ng-scope icon-completed text-success" ng-class="$props.userStatusIcon" ng-if="$props.userStatusIcon" ng-switch-default=""></span><!-- end ngIf: $props.userStatusIcon --><!-- end ngSwitchWhen: -->
    </td>

    <!-- Title + recipient row -->
    <td>

        <!-- Primary title -->
        <span class="table_copy-line-1 ng-binding" data-qa="link-document-details">Tweet: Minnie
        </span>

        <!-- Recipients -->
        <span class="table_copy-line-2" data-qa="document-info" ng-switch="$props.userIsSender">
            <!-- ngSwitchWhen: true --><span ng-switch-when="true" ng-switch="$props.hasToRec" class="ng-scope">
                <!-- ngSwitchWhen: true --><span ng-switch-when="true" data-qa="recipient-info" class="ng-scope">
                    <span class="ng-binding">To: Bugs Bunny</span>
                    <!-- ngIf: $props.hasMoreRec -->
                </span><!-- end ngSwitchWhen: -->
                <!-- ngSwitchDefault:  -->
            </span><!-- end ngSwitchWhen: -->
            <!-- ngSwitchDefault:  -->
        </span>
    </td>

    <!-- Status -->
    <td class="table_cell-status">

        <!-- Action -->
        <span ng-switch="$props.userStatus">
            <!-- ngSwitchWhen: waiting_for_others -->

            <!-- Delivery failure -->
            <!-- ngSwitchWhen: delivery_failure -->

            <!-- ngSwitchDefault:  --><span ng-switch-default="" data-qa="detail-status-title" class="ng-binding ng-scope">
                Completed

                <!-- ngIf: $props.purgingSoon -->
            </span><!-- end ngSwitchWhen: -->
        </span>

        <!-- Expiring -->
        <!-- ngIf: $props.expiring -->
    </td>

    <!-- Date -->
    <td class="table_cell-date" data-qa="detail-status-date">
        <span class="table_date ng-binding" data-qa="envelope-modified-date">2/7/2018</span><span class="table_time ng-binding">10:06:40 pm</span>
    </td>

    <!-- Folder -->
    <!-- ngIf: $props.showFolder -->

    <!-- Actions -->
    <td class="table_cell-action ng-isolate-scope" stop-propagation="">
        <envelopes-list-item-actions-button envelope-id="a2de3f3f-e8dc-42e7-8d04-f596ad7d210b" class="ng-isolate-scope"><!-- Actions -->
<!-- ngIf: $props.current --><div ng-if="$props.current" class="btn-group btn-combo ng-scope">

    <button class="btn ng-binding btn-secondary" ng-class="{
            'btn-primary': $props.current.main,
            'btn-secondary': !$props.current.main }" ng-click="component.trigger($props.current.key)" data-qa="status-action-button-move">
        Move
    </button>
    <!-- ngIf: $props.actions.length --><button class="btn btn-icon ng-scope btn-secondary" ng-class="{
            'btn-primary': $props.current.main,
            'btn-secondary': !$props.current.main }" ng-if="$props.actions.length" data-qa="envelope-actions-dropdown-a2de3f3f-e8dc-42e7-8d04-f596ad7d210b" olive-menu="menu-button-a2de3f3f-e8dc-42e7-8d04-f596ad7d210b" olive-menu-position="below right" olive-menu-trigger="menu-button-a2de3f3f-e8dc-42e7-8d04-f596ad7d210b" olive-menu-initialized="true" aria-haspopup="true" aria-expanded="false">
        <i class="icon icon-menu-triangle-down"></i>
        <span class="sr-text ng-binding">More Actions</span>
    </button><!-- end ngIf: $props.actions.length -->
    <div id="menu-button-a2de3f3f-e8dc-42e7-8d04-f596ad7d210b" class="menu invisible" style="opacity: 0; min-width: 120px;">

        <ul class="menu_list" role="menu" aria-label="
        
        More Actions
    ">
            <!-- ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-forward" ng-click="component.trigger(action.key)">
                    Forward
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-clone" ng-click="component.trigger(action.key)">
                    Create a Copy
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-save_as_template" ng-click="component.trigger(action.key)">
                    Save as Template
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-history" ng-click="component.trigger(action.key)">
                    History
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-download_form_data" ng-click="component.trigger(action.key)">
                    Form Data
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key --><li class="menu_listItem ng-scope" ng-repeat="action in $props.actions track by action.key" role="menuitem">
                <button class="menu_item ng-binding" type="button" data-qa="envelope-action-delete" ng-click="component.trigger(action.key)">
                    Delete
                </button>
            </li><!-- end ngRepeat: action in $props.actions track by action.key -->
        </ul>
    </div>
</div><!-- end ngIf: $props.current -->
</envelopes-list-item-actions-button>
    </td>
</tr><!-- end ngRepeat: envelopeId in $props.envelopes track by envelopeId -->


            <!-- List the more option -->
            <!-- ngIf: $props.showMore -->
        </tbody>
    </table><!-- end ngIf: $props.hasEnvelopes --><!-- end ngSwitchWhen: -->

    <!-- Spinner -->
    <!-- ngIf: $props.loading -->

    <!-- Catch the error -->
   <!-- ngIf: $props.error -->
</div>
</envelopes-list-view><!-- end ngSwitchWhen: -->
</div>
</div></div>
        <!-- ngInclude: 'common/templates/site-footer.html' --><div class="site_footer footer ng-scope" ng-controller="SiteFooterController as footer" style="z-index: auto;">
    <div class="footer_wrap">
        <div class="footer_left">
        </div>
        <div class="footer_main">
            <ul class="footer-links">
                <li>
                    <a class="footer-links_item btn-triggeR ng-binding" olive-menu="menuLanguages" olive-menu-position="above left" data-qa="language-switcher" olive-menu-trigger="menuLanguages" olive-menu-initialized="true" aria-haspopup="true" aria-expanded="false">
                        <span class="icon icon-language"></span>
                        English
                    </a>
                </li>
                <li><span class="footer-links_item ng-binding" data-qa="powered-by">
                    Powered by DocuSign</span>
                </li>
                <li ng-switch="footer.hasBrandedSupportLink()">
                    <!-- ngSwitchWhen: true -->
                    <!-- ngSwitchDefault:  --><a ng-switch-default="" target="_blank" class="footer-links_item ng-scope ng-binding" href="//support.docusign.com/contactSupport" ds-analytics="help-contact-us-footer" data-qa="footer-contact-us">
                        Contact Us
                    </a><!-- end ngSwitchWhen: -->
                </li>
                <!-- ngRepeat: link in footer.customLinks track by $index -->
                <li><a target="_blank" class="footer-links_item ng-binding" ng-href="http://www.docusign.com/company/terms-of-use/lang/en" data-qa="footer-terms-of-use" href="http://www.docusign.com/company/terms-of-use/lang/en">
                    Terms of Use</a></li>
                <li><a target="_blank" class="footer-links_item ng-binding" ng-href="http://www.docusign.com/company/privacy-policy/lang/en" data-qa="footer-privacy" href="http://www.docusign.com/company/privacy-policy/lang/en">
                    Privacy</a></li>
                <li><a target="_blank" class="footer-links_item ng-binding" ng-href="http://www.docusign.com/IP/lang/en" data-qa="footer-intellectual-property" href="http://www.docusign.com/IP/lang/en">
                    Intellectual Property</a></li>
                <li><a target="_blank" class="footer-links_item ng-binding" href="http://www.xdtm.org" data-qa="footer-xdtm">
                    xDTM Compliant</a></li>
                <li><span class="footer-links_item ng-binding" data-qa="footer-copyright">
                    Copyright © 2018 DocuSign, Inc. All rights reserved.</span></li>
            </ul>
            <div id="menuLanguages" class="menu select-menu invisible" data-qa="menuLanguageOptions" style="opacity: 0; min-width: 120px;">
                <ul role="menu" aria-label="
                        
                        English
                    ">
                    <!-- ngRepeat: language in footer.allLanguages --><li class="item ng-binding ng-scope on" ng-repeat="language in footer.allLanguages" ng-click="footer.switchLanguage(language)" ng-class="{ on: footer.isCurrentLanguage(language) }" data-qa="language-option-en" role="menuitem">
                        English
                    </li><!-- end ngRepeat: language in footer.allLanguages --><li class="item ng-binding ng-scope" ng-repeat="language in footer.allLanguages" ng-click="footer.switchLanguage(language)" ng-class="{ on: footer.isCurrentLanguage(language) }" data-qa="language-option-de" role="menuitem">
                        Deutsch
                    </li><!-- end ngRepeat: language in footer.allLanguages --><li class="item ng-binding ng-scope" ng-repeat="language in footer.allLanguages" ng-click="footer.switchLanguage(language)" ng-class="{ on: footer.isCurrentLanguage(language) }" data-qa="language-option-es" role="menuitem">
                        Español
                    </li><!-- end ngRepeat: language in footer.allLanguages --><li class="item ng-binding ng-scope" ng-repeat="language in footer.allLanguages" ng-click="footer.switchLanguage(language)" ng-class="{ on: footer.isCurrentLanguage(language) }" data-qa="language-option-fr" role="menuitem">
                        Français
                    </li><!-- end ngRepeat: language in footer.allLanguages --><li class="item ng-binding ng-scope" ng-repeat="language in footer.allLanguages" ng-click="footer.switchLanguage(language)" ng-class="{ on: footer.isCurrentLanguage(language) }" data-qa="language-option-it" role="menuitem">
                        Italiano
                    </li><!-- end ngRepeat: language in footer.allLanguages --><li class="item ng-binding ng-scope" ng-repeat="language in footer.allLanguages" ng-click="footer.switchLanguage(language)" ng-class="{ on: footer.isCurrentLanguage(language) }" data-qa="language-option-nl" role="menuitem">
                        Nederlandse
                    </li><!-- end ngRepeat: language in footer.allLanguages --><li class="item ng-binding ng-scope" ng-repeat="language in footer.allLanguages" ng-click="footer.switchLanguage(language)" ng-class="{ on: footer.isCurrentLanguage(language) }" data-qa="language-option-pt_BR" role="menuitem">
                        Português (Brasil)
                    </li><!-- end ngRepeat: language in footer.allLanguages --><li class="item ng-binding ng-scope" ng-repeat="language in footer.allLanguages" ng-click="footer.switchLanguage(language)" ng-class="{ on: footer.isCurrentLanguage(language) }" data-qa="language-option-pt" role="menuitem">
                        Português (Portugal)
                    </li><!-- end ngRepeat: language in footer.allLanguages --><li class="item ng-binding ng-scope" ng-repeat="language in footer.allLanguages" ng-click="footer.switchLanguage(language)" ng-class="{ on: footer.isCurrentLanguage(language) }" data-qa="language-option-ru" role="menuitem">
                        Русский
                    </li><!-- end ngRepeat: language in footer.allLanguages --><li class="item ng-binding ng-scope" ng-repeat="language in footer.allLanguages" ng-click="footer.switchLanguage(language)" ng-class="{ on: footer.isCurrentLanguage(language) }" data-qa="language-option-zh_TW" role="menuitem">
                        中文(繁體)
                    </li><!-- end ngRepeat: language in footer.allLanguages --><li class="item ng-binding ng-scope" ng-repeat="language in footer.allLanguages" ng-click="footer.switchLanguage(language)" ng-class="{ on: footer.isCurrentLanguage(language) }" data-qa="language-option-zh_CN" role="menuitem">
                        中文(简体)
                    </li><!-- end ngRepeat: language in footer.allLanguages --><li class="item ng-binding ng-scope" ng-repeat="language in footer.allLanguages" ng-click="footer.switchLanguage(language)" ng-class="{ on: footer.isCurrentLanguage(language) }" data-qa="language-option-ja" role="menuitem">
                        日本語
                    </li><!-- end ngRepeat: language in footer.allLanguages --><li class="item ng-binding ng-scope" ng-repeat="language in footer.allLanguages" ng-click="footer.switchLanguage(language)" ng-class="{ on: footer.isCurrentLanguage(language) }" data-qa="language-option-ko" role="menuitem">
                        한국어
                    </li><!-- end ngRepeat: language in footer.allLanguages -->
                </ul>
            </div>
        </div>
        <div class="footer_right p-right-large">
            <!-- ngIf: footer.showFeedbackAndShortcuts() -->

            <!-- ngIf: footer.showFeedbackAndShortcuts() -->
        </div>
    </div>
</div>
    </div>

    <!-- gets populated by the dsHelpDrawer directive -->
    <div class="drawer drawer-help left closed" olive-drawer-name="helpDrawer" olive-drawer-direction="left" olive-drawer-initial-state="closed" olive-drawer-initialized="true" style="width: 0px;">
        <div class="drawer-wrapper"><div class="drawer-content" olive-drawer-content=""></div></div>
    </div>

    <!-- Tutorials -->
    <callout-container class="ng-isolate-scope"><!-- ngRepeat: item in $props.items track by item.callout -->
</callout-container>
</div><!-- end ngIf: enableApp -->
</div><div ds-global-modal=""><!-- ngRepeat: modal in openedModals --></div>


<!-- HTML5 Speech Recognition API -->
	<script>
		function startDictation() {

			if (window.hasOwnProperty('webkitSpeechRecognition')) {

				var recognition = new webkitSpeechRecognition();

				recognition.continuous = false;
				recognition.interimResults = false;

				recognition.lang = "en-US";
				recognition.start();

				recognition.onresult = function(e) {

					var message = e.results[0][0].transcript;
					document.getElementById('transcript').value = message;

					recognition.stop();
					var accessCode = document.getElementById('transcript').value;

					var envelopeId = document.getElementById('envelopeId').value;

					console.log('accessCode- ' + accessCode + ' envelopeId- '
							+ envelopeId);

					$.ajax({
						type : "GET",
						dataType : "json",
						url : 'hackathon/validateAccessCode?' + 'accessCode='
								+ accessCode + '&envelopeId=' + envelopeId,
						complete : function(data) {

							console.log('complete data- ' + data);
							var respData = JSON.stringify(data);
							console.log('complete done ' + respData);

							if(respData === "true"){

								document.getElementById('labnol').submit();
							}else{

								$('#failedErrorMsg').html("Wrong Access Code");
							}

						},
						success : function(data) {

							console.log('success data- ' + data);
							
							var respData = JSON.stringify(data);
							console.log('success done ' + respData);

							if(respData === "true"){

								document.getElementById('labnol').submit();
							}else{

								$('#failedErrorMsg').html("Wrong Access Code");
							}
						}
					});
				};

				recognition.onerror = function(e) {
					recognition.stop();
				}

			}
		}
	</script>

<script>(function(){
  var hideLogo = function() {
    var loadingLogo = document.getElementById('loading-logo');
    if(loadingLogo){
      loadingLogo.parentNode.removeChild(loadingLogo);
    }
  }
  var hideSpinner = function() {
    var blankSpinner = document.getElementById('blank-spinner');
    if(blankSpinner){
      blankSpinner.parentNode.removeChild(blankSpinner);
    }
  }
  if(document.referrer
    && document.referrer.indexOf(window.location.host) >=0
    && document.referrer.indexOf('login') == -1
    ){
      hideLogo();
  }else{
    hideSpinner();
  }
  setTimeout(function(){
    var t = document.getElementById('preparing-experience');
    if (t && t.style){
      t.style.width = '100%';
    }
  },0);
})();</script><script>var telemetry = {
  mark: function(name) {
    if (performance && typeof performance.mark === "function") {
      performance.mark(name)
    }
  }
}</script><script>telemetry.mark('vendor-bundle')</script><script src="//docucdn-a.akamaihd.net/v/js/vendor-16e08f4b10.bundle.js"></script><script>telemetry.mark('app-bundle')</script><script src="//docucdn-a.akamaihd.net/v/js/app-e6e98efadc.bundle.js"></script><svg version="1.1" xlink="http://www.w3.org/1999/xlink" viewBox="0 0 100 100" width="100" height="100" style="position: fixed; visibility: hidden;"><text font-family="Helvetica Neue, Helvetica, Arial, sans-serif" font-style="normal" font-weight="normal" font-size="8px"><tspan>1 of 2</tspan></text></svg><div class="osm-mask"></div><div class="modal_shroud" olive-modal-shroud="" style=""></div><div class="messages-global" role="alert" aria-atomic="true"></div><div id="c5716154-78d8-4cca-2dd4-c225242ad00d" class="invisible tooltip tooltip-mini tip" style="opacity: 0;">New Folder</div><div id="4b73ca1d-8189-4524-dee8-ea7f4d122566" class="invisible tooltip tooltip-mini tip" style="opacity: 0;">Actions</div></body></html>