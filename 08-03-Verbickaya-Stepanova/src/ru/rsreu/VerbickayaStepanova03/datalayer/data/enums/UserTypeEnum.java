package ru.rsreu.VerbickayaStepanova03.datalayer.data.enums;

public enum UserTypeEnum {
	
	admin {
		public String string() {
			return "admin";
		}
	},
	moder {
		public String string() {
			return "moder";
		}
	},
	user {
		public String string() {
			return "user";
		}
	};

	abstract String string();

	@Override
	public String toString() {
		return this.string();
	}

	public static UserTypeEnum toType(String status) {
		if (status.equals(UserTypeEnum.admin.toString())) {
			return UserTypeEnum.admin;
		} else if (status.equals(UserTypeEnum.moder.toString())) {
			return UserTypeEnum.moder;
		} else if (status.equals(UserTypeEnum.user.toString())) {
			return UserTypeEnum.user;
		} else {
			return null;
		}
	}
}
