package VO;

import java.io.Serializable;

public class GunBulletVO implements Serializable {
		
		private int bullet_id;
		private int bullet_no;
		private int gun_id ;
		
		private GunVO gunVO;

		public int getBullet_id() {
			return bullet_id;
		}

		public void setBullet_id(int bullet_id) {
			this.bullet_id = bullet_id;
		}

		public int getBullet_no() {
			return bullet_no;
		}

		public void setBullet_no(int bullet_no) {
			this.bullet_no = bullet_no;
		}

		public int getGun_id() {
			return gun_id;
		}

		public void setGun_id(int gun_id) {
			this.gun_id = gun_id;
		}

		public GunVO getGunVO() {
			return gunVO;
		}

		public void setGunVO(GunVO gunVO) {
			this.gunVO = gunVO;
		}
		
}
