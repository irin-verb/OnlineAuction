package ru.rsreu.VerbickayaStepanova03.datalayer.data.enums;

public enum GoodStatusEnum {
	selling {
		public String string() {
			return "selling";
		}
	},
	sold {
		public String string() {
			return "sold";
		}
	},
	removed {
		public String string() {
			return "removed";
		}
	};

	abstract String string();

	@Override
	public String toString() {
		return this.string();
	}

	public static GoodStatusEnum toStatus(String status) {
		if (status.equals(GoodStatusEnum.selling.toString())) {
			return GoodStatusEnum.selling;
		} else if (status.equals(GoodStatusEnum.sold.toString())) {
			return GoodStatusEnum.sold;
		} else if (status.equals(GoodStatusEnum.removed.toString())) {
			return GoodStatusEnum.removed;
		} else {
			return null;
		}
	}
}
