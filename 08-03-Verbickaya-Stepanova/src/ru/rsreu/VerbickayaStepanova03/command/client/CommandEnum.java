package ru.rsreu.VerbickayaStepanova03.command.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.rsreu.VerbickayaStepanova03.command.ActionCommand;
import ru.rsreu.VerbickayaStepanova03.command.good.EditGoodCommand;
import ru.rsreu.VerbickayaStepanova03.command.good.NewGoodCommand;
import ru.rsreu.VerbickayaStepanova03.command.good.OpenGoodCommand;
import ru.rsreu.VerbickayaStepanova03.command.good.RaisePriceCommand;
import ru.rsreu.VerbickayaStepanova03.command.good.RemoveGoodCommand;
import ru.rsreu.VerbickayaStepanova03.command.good.SaveGoodCommand;
import ru.rsreu.VerbickayaStepanova03.command.good.SaveNewGoodCommand;
import ru.rsreu.VerbickayaStepanova03.command.section.GoodsCommand;
import ru.rsreu.VerbickayaStepanova03.command.section.HomeCommand;
import ru.rsreu.VerbickayaStepanova03.command.section.MyGoodsCommand;
import ru.rsreu.VerbickayaStepanova03.command.section.TradesCommand;
import ru.rsreu.VerbickayaStepanova03.command.section.UsersCommand;
import ru.rsreu.VerbickayaStepanova03.command.settings.SaveSettingsCommand;
import ru.rsreu.VerbickayaStepanova03.command.settings.SettingsCommand;
import ru.rsreu.VerbickayaStepanova03.command.trade.OpenTradeCommand;
import ru.rsreu.VerbickayaStepanova03.command.user.EditUserCommand;
import ru.rsreu.VerbickayaStepanova03.command.user.LoginCommand;
import ru.rsreu.VerbickayaStepanova03.command.user.LogoutCommand;
import ru.rsreu.VerbickayaStepanova03.command.user.NewUserCommand;
import ru.rsreu.VerbickayaStepanova03.command.user.OpenUserCommand;
import ru.rsreu.VerbickayaStepanova03.command.user.RemoveUserCommand;
import ru.rsreu.VerbickayaStepanova03.command.user.ReverseBlockingStatusCommand;
import ru.rsreu.VerbickayaStepanova03.command.user.SaveNewUserCommand;
import ru.rsreu.VerbickayaStepanova03.command.user.SaveUserCommand;
import ru.rsreu.VerbickayaStepanova03.datalayer.data.enums.UserTypeEnum;

public enum CommandEnum {

	LOGIN {
		{
			this.command = new LoginCommand();
			this.rights = new ArrayList<UserTypeEnum>(
					Arrays.asList(UserTypeEnum.admin, UserTypeEnum.moder, UserTypeEnum.user));
		}
	},
	LOGOUT {
		{
			this.command = new LogoutCommand();
			this.rights = new ArrayList<UserTypeEnum>(
					Arrays.asList(UserTypeEnum.admin, UserTypeEnum.moder, UserTypeEnum.user));
		}
	},
	HOME {
		{
			this.command = new HomeCommand();
			this.rights = new ArrayList<UserTypeEnum>(
					Arrays.asList(UserTypeEnum.admin, UserTypeEnum.moder, UserTypeEnum.user));
		}
	},
	GOODS {
		{
			this.command = new GoodsCommand();
			this.rights = new ArrayList<UserTypeEnum>(Arrays.asList(UserTypeEnum.moder, UserTypeEnum.user));
		}
	},
	TRADES {
		{
			this.command = new TradesCommand();
			this.rights = new ArrayList<UserTypeEnum>(Arrays.asList(UserTypeEnum.user));
		}
	},
	USERS {
		{
			this.command = new UsersCommand();
			this.rights = new ArrayList<UserTypeEnum>(Arrays.asList(UserTypeEnum.admin, UserTypeEnum.moder));
		}
	},
	MYGOODS {
		{
			this.command = new MyGoodsCommand();
			this.rights = new ArrayList<UserTypeEnum>(Arrays.asList(UserTypeEnum.user));
		}
	},
	OPENGOOD {
		{
			this.command = new OpenGoodCommand();
			this.rights = new ArrayList<UserTypeEnum>(Arrays.asList(UserTypeEnum.moder, UserTypeEnum.user));
		}
	},
	OPENTRADE {
		{
			this.command = new OpenTradeCommand();
			this.rights = new ArrayList<UserTypeEnum>(Arrays.asList(UserTypeEnum.user));
		}
	},
	OPENUSER {
		{
			this.command = new OpenUserCommand();
			this.rights = new ArrayList<UserTypeEnum>(Arrays.asList(UserTypeEnum.admin, UserTypeEnum.moder));
		}
	},
	RAISEPRICE {
		{
			this.command = new RaisePriceCommand();
			this.rights = new ArrayList<UserTypeEnum>(Arrays.asList(UserTypeEnum.user));
		}
	},
	REMOVEGOOD {
		{
			this.command = new RemoveGoodCommand();
			this.rights = new ArrayList<UserTypeEnum>(Arrays.asList(UserTypeEnum.moder, UserTypeEnum.user));
		}
	},
	EDITGOOD {
		{
			this.command = new EditGoodCommand();
			this.rights = new ArrayList<UserTypeEnum>(Arrays.asList(UserTypeEnum.moder, UserTypeEnum.user));
		}
	},
	SAVEGOOD {
		{
			this.command = new SaveGoodCommand();
			this.rights = new ArrayList<UserTypeEnum>(Arrays.asList(UserTypeEnum.moder, UserTypeEnum.user));
		}
	},
	NEWGOOD {
		{
			this.command = new NewGoodCommand();
			this.rights = new ArrayList<UserTypeEnum>(Arrays.asList(UserTypeEnum.user));
		}
	},
	SAVENEWGOOD {
		{
			this.command = new SaveNewGoodCommand();
			this.rights = new ArrayList<UserTypeEnum>(Arrays.asList(UserTypeEnum.user));
		}
	},
	SETTINGS {
		{
			this.command = new SettingsCommand();
			this.rights = new ArrayList<UserTypeEnum>(Arrays.asList(UserTypeEnum.moder));
		}
	},
	SAVESETTINGS {
		{
			this.command = new SaveSettingsCommand();
			this.rights = new ArrayList<UserTypeEnum>(Arrays.asList(UserTypeEnum.moder));
		}
	},
	REVERSEBLOCKINGSTATUS {
		{
			this.command = new ReverseBlockingStatusCommand();
			this.rights = new ArrayList<UserTypeEnum>(Arrays.asList(UserTypeEnum.moder));
		}
	},
	REMOVEUSER {
		{
			this.command = new RemoveUserCommand();
			this.rights = new ArrayList<UserTypeEnum>(Arrays.asList(UserTypeEnum.admin));
		}
	},
	EDITUSER {
		{
			this.command = new EditUserCommand();
			this.rights = new ArrayList<UserTypeEnum>(Arrays.asList(UserTypeEnum.admin));
		}
	},
	SAVEUSER {
		{
			this.command = new SaveUserCommand();
			this.rights = new ArrayList<UserTypeEnum>(Arrays.asList(UserTypeEnum.admin));
		}
	},
	NEWUSER {
		{
			this.command = new NewUserCommand();
			this.rights = new ArrayList<UserTypeEnum>(Arrays.asList(UserTypeEnum.admin));
		}
	},
	SAVENEWUSER {
		{
			this.command = new SaveNewUserCommand();
			this.rights = new ArrayList<UserTypeEnum>(Arrays.asList(UserTypeEnum.admin));
		}
	};

	ActionCommand command;
	List<UserTypeEnum> rights;

	public ActionCommand getCurrentCommand() {
		return command;
	}

	public List<UserTypeEnum> getAccessRights() {
		return rights;
	}

	public boolean isValidAccessRights(UserTypeEnum type) {
		return rights.contains(type);
	}
}
