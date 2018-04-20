package com.rairmmd.facedetect.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Rair
 * @date 2018/1/17
 * <p>
 * desc:
 */

public class FaceModel {

    /**
     * image_id : q/E9DaGtMbc3jHo04yIwKA==
     * request_id : 1516159424,63b7efe4-7379-434b-825c-09c2f16ad594
     * time_used : 334
     * faces : [{"landmark":{"mouth_upper_lip_left_contour2":{"y":493,"x":490},"mouth_upper_lip_left_contour3":{"y":499,"x":498},"mouth_lower_lip_right_contour3":{"y":512,"x":555},"mouth_upper_lip_left_contour1":{"y":490,"x":514},"left_eye_upper_left_quarter":{"y":318,"x":433},"left_eyebrow_lower_middle":{"y":308,"x":434},"contour_chin":{"y":605,"x":533},"left_eyebrow_lower_left_quarter":{"y":305,"x":411},"right_eyebrow_lower_left_quarter":{"y":310,"x":584},"mouth_lower_lip_right_contour1":{"y":498,"x":561},"mouth_lower_lip_left_contour2":{"y":508,"x":485},"left_eye_bottom":{"y":336,"x":447},"mouth_lower_lip_bottom":{"y":516,"x":530},"contour_left9":{"y":597,"x":490},"mouth_lower_lip_top":{"y":503,"x":529},"right_eyebrow_upper_middle":{"y":294,"x":607},"right_eyebrow_left_corner":{"y":309,"x":561},"right_eye_bottom":{"y":335,"x":594},"contour_left7":{"y":547,"x":431},"contour_left6":{"y":515,"x":409},"contour_left5":{"y":480,"x":394},"contour_left4":{"y":442,"x":384},"contour_left3":{"y":404,"x":378},"contour_left2":{"y":366,"x":373},"contour_left1":{"y":327,"x":370},"left_eye_lower_left_quarter":{"y":332,"x":431},"mouth_upper_lip_top":{"y":492,"x":528},"contour_right3":{"y":402,"x":686},"contour_right2":{"y":364,"x":689},"mouth_left_corner":{"y":497,"x":467},"contour_right4":{"y":441,"x":681},"contour_right7":{"y":545,"x":636},"left_eyebrow_left_corner":{"y":303,"x":390},"nose_right":{"y":435,"x":570},"right_eye_upper_right_quarter":{"y":319,"x":608},"nose_tip":{"y":443,"x":523},"contour_right5":{"y":478,"x":672},"nose_contour_lower_middle":{"y":462,"x":526},"right_eye_top":{"y":316,"x":593},"mouth_lower_lip_left_contour3":{"y":515,"x":506},"right_eye_right_corner":{"y":328,"x":621},"right_eye_lower_right_quarter":{"y":333,"x":608},"mouth_upper_lip_right_contour2":{"y":488,"x":567},"right_eyebrow_lower_right_quarter":{"y":310,"x":628},"left_eye_left_corner":{"y":325,"x":419},"mouth_right_corner":{"y":489,"x":593},"mouth_upper_lip_right_contour3":{"y":495,"x":561},"right_eye_lower_left_quarter":{"y":333,"x":579},"left_eyebrow_right_corner":{"y":316,"x":483},"left_eyebrow_lower_right_quarter":{"y":313,"x":458},"right_eye_center":{"y":328,"x":593},"left_eye_upper_right_quarter":{"y":320,"x":464},"mouth_lower_lip_left_contour1":{"y":502,"x":498},"contour_left8":{"y":575,"x":457},"nose_left":{"y":439,"x":482},"right_eyebrow_lower_middle":{"y":308,"x":607},"left_eye_top":{"y":316,"x":448},"left_eye_center":{"y":327,"x":448},"left_eye_lower_right_quarter":{"y":334,"x":463},"nose_contour_right1":{"y":331,"x":545},"contour_right9":{"y":596,"x":576},"right_eye_left_corner":{"y":331,"x":566},"left_eyebrow_upper_left_quarter":{"y":290,"x":412},"left_eye_pupil":{"y":325,"x":449},"right_eyebrow_upper_left_quarter":{"y":297,"x":583},"contour_right8":{"y":573,"x":609},"right_eyebrow_right_corner":{"y":313,"x":648},"right_eye_upper_left_quarter":{"y":320,"x":578},"left_eyebrow_upper_middle":{"y":293,"x":437},"right_eyebrow_upper_right_quarter":{"y":297,"x":630},"nose_contour_left1":{"y":333,"x":500},"nose_contour_left2":{"y":412,"x":491},"mouth_upper_lip_right_contour1":{"y":488,"x":542},"contour_right1":{"y":324,"x":689},"nose_contour_right2":{"y":409,"x":559},"mouth_lower_lip_right_contour2":{"y":502,"x":575},"contour_right6":{"y":514,"x":657},"nose_contour_right3":{"y":451,"x":550},"nose_contour_left3":{"y":453,"x":502},"left_eye_right_corner":{"y":331,"x":478},"left_eyebrow_upper_right_quarter":{"y":301,"x":460},"right_eye_pupil":{"y":324,"x":593},"mouth_upper_lip_bottom":{"y":500,"x":529}},"face_rectangle":{"width":336,"top":287,"left":362,"height":336},"face_token":"ccbb4e593e06dbd5ab194ba215947f58"}]
     */

    @SerializedName("image_id")
    private String imageId;
    @SerializedName("request_id")
    private String requestId;
    @SerializedName("time_used")
    private int timeUsed;
    @SerializedName("faces")
    private List<FacesBean> faces;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(int timeUsed) {
        this.timeUsed = timeUsed;
    }

    public List<FacesBean> getFaces() {
        return faces;
    }

    public void setFaces(List<FacesBean> faces) {
        this.faces = faces;
    }

    public static class FacesBean {
        /**
         * landmark : {"mouth_upper_lip_left_contour2":{"y":493,"x":490},"mouth_upper_lip_left_contour3":{"y":499,"x":498},"mouth_lower_lip_right_contour3":{"y":512,"x":555},"mouth_upper_lip_left_contour1":{"y":490,"x":514},"left_eye_upper_left_quarter":{"y":318,"x":433},"left_eyebrow_lower_middle":{"y":308,"x":434},"contour_chin":{"y":605,"x":533},"left_eyebrow_lower_left_quarter":{"y":305,"x":411},"right_eyebrow_lower_left_quarter":{"y":310,"x":584},"mouth_lower_lip_right_contour1":{"y":498,"x":561},"mouth_lower_lip_left_contour2":{"y":508,"x":485},"left_eye_bottom":{"y":336,"x":447},"mouth_lower_lip_bottom":{"y":516,"x":530},"contour_left9":{"y":597,"x":490},"mouth_lower_lip_top":{"y":503,"x":529},"right_eyebrow_upper_middle":{"y":294,"x":607},"right_eyebrow_left_corner":{"y":309,"x":561},"right_eye_bottom":{"y":335,"x":594},"contour_left7":{"y":547,"x":431},"contour_left6":{"y":515,"x":409},"contour_left5":{"y":480,"x":394},"contour_left4":{"y":442,"x":384},"contour_left3":{"y":404,"x":378},"contour_left2":{"y":366,"x":373},"contour_left1":{"y":327,"x":370},"left_eye_lower_left_quarter":{"y":332,"x":431},"mouth_upper_lip_top":{"y":492,"x":528},"contour_right3":{"y":402,"x":686},"contour_right2":{"y":364,"x":689},"mouth_left_corner":{"y":497,"x":467},"contour_right4":{"y":441,"x":681},"contour_right7":{"y":545,"x":636},"left_eyebrow_left_corner":{"y":303,"x":390},"nose_right":{"y":435,"x":570},"right_eye_upper_right_quarter":{"y":319,"x":608},"nose_tip":{"y":443,"x":523},"contour_right5":{"y":478,"x":672},"nose_contour_lower_middle":{"y":462,"x":526},"right_eye_top":{"y":316,"x":593},"mouth_lower_lip_left_contour3":{"y":515,"x":506},"right_eye_right_corner":{"y":328,"x":621},"right_eye_lower_right_quarter":{"y":333,"x":608},"mouth_upper_lip_right_contour2":{"y":488,"x":567},"right_eyebrow_lower_right_quarter":{"y":310,"x":628},"left_eye_left_corner":{"y":325,"x":419},"mouth_right_corner":{"y":489,"x":593},"mouth_upper_lip_right_contour3":{"y":495,"x":561},"right_eye_lower_left_quarter":{"y":333,"x":579},"left_eyebrow_right_corner":{"y":316,"x":483},"left_eyebrow_lower_right_quarter":{"y":313,"x":458},"right_eye_center":{"y":328,"x":593},"left_eye_upper_right_quarter":{"y":320,"x":464},"mouth_lower_lip_left_contour1":{"y":502,"x":498},"contour_left8":{"y":575,"x":457},"nose_left":{"y":439,"x":482},"right_eyebrow_lower_middle":{"y":308,"x":607},"left_eye_top":{"y":316,"x":448},"left_eye_center":{"y":327,"x":448},"left_eye_lower_right_quarter":{"y":334,"x":463},"nose_contour_right1":{"y":331,"x":545},"contour_right9":{"y":596,"x":576},"right_eye_left_corner":{"y":331,"x":566},"left_eyebrow_upper_left_quarter":{"y":290,"x":412},"left_eye_pupil":{"y":325,"x":449},"right_eyebrow_upper_left_quarter":{"y":297,"x":583},"contour_right8":{"y":573,"x":609},"right_eyebrow_right_corner":{"y":313,"x":648},"right_eye_upper_left_quarter":{"y":320,"x":578},"left_eyebrow_upper_middle":{"y":293,"x":437},"right_eyebrow_upper_right_quarter":{"y":297,"x":630},"nose_contour_left1":{"y":333,"x":500},"nose_contour_left2":{"y":412,"x":491},"mouth_upper_lip_right_contour1":{"y":488,"x":542},"contour_right1":{"y":324,"x":689},"nose_contour_right2":{"y":409,"x":559},"mouth_lower_lip_right_contour2":{"y":502,"x":575},"contour_right6":{"y":514,"x":657},"nose_contour_right3":{"y":451,"x":550},"nose_contour_left3":{"y":453,"x":502},"left_eye_right_corner":{"y":331,"x":478},"left_eyebrow_upper_right_quarter":{"y":301,"x":460},"right_eye_pupil":{"y":324,"x":593},"mouth_upper_lip_bottom":{"y":500,"x":529}}
         * face_rectangle : {"width":336,"top":287,"left":362,"height":336}
         * face_token : ccbb4e593e06dbd5ab194ba215947f58
         */

        @SerializedName("landmark")
        private LandmarkBean landmark;
        @SerializedName("face_rectangle")
        private FaceRectangleBean faceRectangle;
        @SerializedName("face_token")
        private String faceToken;

        public LandmarkBean getLandmark() {
            return landmark;
        }

        public void setLandmark(LandmarkBean landmark) {
            this.landmark = landmark;
        }

        public FaceRectangleBean getFaceRectangle() {
            return faceRectangle;
        }

        public void setFaceRectangle(FaceRectangleBean faceRectangle) {
            this.faceRectangle = faceRectangle;
        }

        public String getFaceToken() {
            return faceToken;
        }

        public void setFaceToken(String faceToken) {
            this.faceToken = faceToken;
        }

        public static class LandmarkBean {
            /**
             * mouth_upper_lip_left_contour2 : {"y":493,"x":490}
             * mouth_upper_lip_left_contour3 : {"y":499,"x":498}
             * mouth_lower_lip_right_contour3 : {"y":512,"x":555}
             * mouth_upper_lip_left_contour1 : {"y":490,"x":514}
             * left_eye_upper_left_quarter : {"y":318,"x":433}
             * left_eyebrow_lower_middle : {"y":308,"x":434}
             * contour_chin : {"y":605,"x":533}
             * left_eyebrow_lower_left_quarter : {"y":305,"x":411}
             * right_eyebrow_lower_left_quarter : {"y":310,"x":584}
             * mouth_lower_lip_right_contour1 : {"y":498,"x":561}
             * mouth_lower_lip_left_contour2 : {"y":508,"x":485}
             * left_eye_bottom : {"y":336,"x":447}
             * mouth_lower_lip_bottom : {"y":516,"x":530}
             * contour_left9 : {"y":597,"x":490}
             * mouth_lower_lip_top : {"y":503,"x":529}
             * right_eyebrow_upper_middle : {"y":294,"x":607}
             * right_eyebrow_left_corner : {"y":309,"x":561}
             * right_eye_bottom : {"y":335,"x":594}
             * contour_left7 : {"y":547,"x":431}
             * contour_left6 : {"y":515,"x":409}
             * contour_left5 : {"y":480,"x":394}
             * contour_left4 : {"y":442,"x":384}
             * contour_left3 : {"y":404,"x":378}
             * contour_left2 : {"y":366,"x":373}
             * contour_left1 : {"y":327,"x":370}
             * left_eye_lower_left_quarter : {"y":332,"x":431}
             * mouth_upper_lip_top : {"y":492,"x":528}
             * contour_right3 : {"y":402,"x":686}
             * contour_right2 : {"y":364,"x":689}
             * mouth_left_corner : {"y":497,"x":467}
             * contour_right4 : {"y":441,"x":681}
             * contour_right7 : {"y":545,"x":636}
             * left_eyebrow_left_corner : {"y":303,"x":390}
             * nose_right : {"y":435,"x":570}
             * right_eye_upper_right_quarter : {"y":319,"x":608}
             * nose_tip : {"y":443,"x":523}
             * contour_right5 : {"y":478,"x":672}
             * nose_contour_lower_middle : {"y":462,"x":526}
             * right_eye_top : {"y":316,"x":593}
             * mouth_lower_lip_left_contour3 : {"y":515,"x":506}
             * right_eye_right_corner : {"y":328,"x":621}
             * right_eye_lower_right_quarter : {"y":333,"x":608}
             * mouth_upper_lip_right_contour2 : {"y":488,"x":567}
             * right_eyebrow_lower_right_quarter : {"y":310,"x":628}
             * left_eye_left_corner : {"y":325,"x":419}
             * mouth_right_corner : {"y":489,"x":593}
             * mouth_upper_lip_right_contour3 : {"y":495,"x":561}
             * right_eye_lower_left_quarter : {"y":333,"x":579}
             * left_eyebrow_right_corner : {"y":316,"x":483}
             * left_eyebrow_lower_right_quarter : {"y":313,"x":458}
             * right_eye_center : {"y":328,"x":593}
             * left_eye_upper_right_quarter : {"y":320,"x":464}
             * mouth_lower_lip_left_contour1 : {"y":502,"x":498}
             * contour_left8 : {"y":575,"x":457}
             * nose_left : {"y":439,"x":482}
             * right_eyebrow_lower_middle : {"y":308,"x":607}
             * left_eye_top : {"y":316,"x":448}
             * left_eye_center : {"y":327,"x":448}
             * left_eye_lower_right_quarter : {"y":334,"x":463}
             * nose_contour_right1 : {"y":331,"x":545}
             * contour_right9 : {"y":596,"x":576}
             * right_eye_left_corner : {"y":331,"x":566}
             * left_eyebrow_upper_left_quarter : {"y":290,"x":412}
             * left_eye_pupil : {"y":325,"x":449}
             * right_eyebrow_upper_left_quarter : {"y":297,"x":583}
             * contour_right8 : {"y":573,"x":609}
             * right_eyebrow_right_corner : {"y":313,"x":648}
             * right_eye_upper_left_quarter : {"y":320,"x":578}
             * left_eyebrow_upper_middle : {"y":293,"x":437}
             * right_eyebrow_upper_right_quarter : {"y":297,"x":630}
             * nose_contour_left1 : {"y":333,"x":500}
             * nose_contour_left2 : {"y":412,"x":491}
             * mouth_upper_lip_right_contour1 : {"y":488,"x":542}
             * contour_right1 : {"y":324,"x":689}
             * nose_contour_right2 : {"y":409,"x":559}
             * mouth_lower_lip_right_contour2 : {"y":502,"x":575}
             * contour_right6 : {"y":514,"x":657}
             * nose_contour_right3 : {"y":451,"x":550}
             * nose_contour_left3 : {"y":453,"x":502}
             * left_eye_right_corner : {"y":331,"x":478}
             * left_eyebrow_upper_right_quarter : {"y":301,"x":460}
             * right_eye_pupil : {"y":324,"x":593}
             * mouth_upper_lip_bottom : {"y":500,"x":529}
             */
            @SerializedName("mouth_upper_lip_left_contour2")
            private MouthUpperLipLeftContour2Bean mouthUpperLipLeftContour2;
            @SerializedName("mouth_upper_lip_left_contour3")
            private MouthUpperLipLeftContour3Bean mouthUpperLipLeftContour3;
            @SerializedName("mouth_lower_lip_right_contour3")
            private MouthLowerLipRightContour3Bean mouthLowerLipRightContour3;
            @SerializedName("mouth_upper_lip_left_contour1")
            private MouthUpperLipLeftContour1Bean mouthUpperLipLeftContour1;
            @SerializedName("left_eye_upper_left_quarter")
            private LeftEyeUpperLeftQuarterBean leftEyeUpperLeftQuarter;
            @SerializedName("left_eyebrow_lower_middle")
            private LeftEyebrowLowerMiddleBean leftEyebrowLowerMiddle;
            @SerializedName("contour_chin")
            private ContourChinBean contourChin;
            @SerializedName("left_eyebrow_lower_left_quarter")
            private LeftEyebrowLowerLeftQuarterBean leftEyebrowLowerLeftQuarter;
            @SerializedName("right_eyebrow_lower_left_quarter")
            private RightEyebrowLowerLeftQuarterBean rightEyebrowLowerLeftQuarter;
            @SerializedName("mouth_lower_lip_right_contour1")
            private MouthLowerLipRightContour1Bean mouthLowerLipRightContour1;
            @SerializedName("mouth_lower_lip_left_contour2")
            private MouthLowerLipLeftContour2Bean mouthLowerLipLeftContour2;
            @SerializedName("left_eye_bottom")
            private LeftEyeBottomBean leftEyeBottom;
            @SerializedName("mouth_lower_lip_bottom")
            private MouthLowerLipBottomBean mouthLowerLipBottom;
            @SerializedName("contour_left9")
            private ContourLeft9Bean contourLeft9;
            @SerializedName("mouth_lower_lip_top")
            private MouthLowerLipTopBean mouthLowerLipTop;
            @SerializedName("right_eyebrow_upper_middle")
            private RightEyebrowUpperMiddleBean rightEyebrowUpperMiddle;
            @SerializedName("right_eyebrow_left_corner")
            private RightEyebrowLeftCornerBean rightEyebrowLeftCorner;
            @SerializedName("right_eye_bottom")
            private RightEyeBottomBean rightEyeBottom;
            @SerializedName("contour_left7")
            private ContourLeft7Bean contourLeft7;
            @SerializedName("contour_left6")
            private ContourLeft6Bean contourLeft6;
            @SerializedName("contour_left5")
            private ContourLeft5Bean contourLeft5;
            @SerializedName("contour_left4")
            private ContourLeft4Bean contourLeft4;
            @SerializedName("contour_left3")
            private ContourLeft3Bean contourLeft3;
            @SerializedName("contour_left2")
            private ContourLeft2Bean contourLeft2;
            @SerializedName("contour_left1")
            private ContourLeft1Bean contourLeft1;
            @SerializedName("left_eye_lower_left_quarter")
            private LeftEyeLowerLeftQuarterBean leftEyeLowerLeftQuarter;
            @SerializedName("mouth_upper_lip_top")
            private MouthUpperLipTopBean mouthUpperLipTop;
            @SerializedName("contour_right3")
            private ContourRight3Bean contourRight3;
            @SerializedName("contour_right2")
            private ContourRight2Bean contourRight2;
            @SerializedName("mouth_left_corner")
            private MouthLeftCornerBean mouthLeftCorner;
            @SerializedName("contour_right4")
            private ContourRight4Bean contourRight4;
            @SerializedName("contour_right7")
            private ContourRight7Bean contourRight7;
            @SerializedName("left_eyebrow_left_corner")
            private LeftEyebrowLeftCornerBean leftEyebrowLeftCorner;
            @SerializedName("nose_right")
            private NoseRightBean noseRight;
            @SerializedName("right_eye_upper_right_quarter")
            private RightEyeUpperRightQuarterBean rightEyeUpperRightQuarter;
            @SerializedName("nose_tip")
            private NoseTipBean noseTip;
            @SerializedName("contour_right5")
            private ContourRight5Bean contourRight5;
            @SerializedName("nose_contour_lower_middle")
            private NoseContourLowerMiddleBean noseContourLowerMiddle;
            @SerializedName("right_eye_top")
            private RightEyeTopBean rightEyeTop;
            @SerializedName("mouth_lower_lip_left_contour3")
            private MouthLowerLipLeftContour3Bean mouthLowerLipLeftContour3;
            @SerializedName("right_eye_right_corner")
            private RightEyeRightCornerBean rightEyeRightCorner;
            @SerializedName("right_eye_lower_right_quarter")
            private RightEyeLowerRightQuarterBean rightEyeLowerRightQuarter;
            @SerializedName("mouth_upper_lip_right_contour2")
            private MouthUpperLipRightContour2Bean mouthUpperLipRightContour2;
            @SerializedName("right_eyebrow_lower_right_quarter")
            private RightEyebrowLowerRightQuarterBean rightEyebrowLowerRightQuarter;
            @SerializedName("left_eye_left_corner")
            private LeftEyeLeftCornerBean leftEyeLeftCorner;
            @SerializedName("mouth_right_corner")
            private MouthRightCornerBean mouthRightCorner;
            @SerializedName("mouth_upper_lip_right_contour3")
            private MouthUpperLipRightContour3Bean mouthUpperLipRightContour3;
            @SerializedName("right_eye_lower_left_quarter")
            private RightEyeLowerLeftQuarterBean rightEyeLowerLeftQuarter;
            @SerializedName("left_eyebrow_right_corner")
            private LeftEyebrowRightCornerBean leftEyebrowRightCorner;
            @SerializedName("left_eyebrow_lower_right_quarter")
            private LeftEyebrowLowerRightQuarterBean leftEyebrowLowerRightQuarter;
            @SerializedName("right_eye_center")
            private RightEyeCenterBean rightEyeCenter;
            @SerializedName("left_eye_upper_right_quarter")
            private LeftEyeUpperRightQuarterBean leftEyeUpperRightQuarter;
            @SerializedName("mouth_lower_lip_left_contour1")
            private MouthLowerLipLeftContour1Bean mouthLowerLipLeftContour1;
            @SerializedName("contour_left8")
            private ContourLeft8Bean contourLeft8;
            @SerializedName("nose_left")
            private NoseLeftBean noseLeft;
            @SerializedName("right_eyebrow_lower_middle")
            private RightEyebrowLowerMiddleBean rightEyebrowLowerMiddle;
            @SerializedName("left_eye_top")
            private LeftEyeTopBean leftEyeTop;
            @SerializedName("left_eye_center")
            private LeftEyeCenterBean leftEyeCenter;
            @SerializedName("left_eye_lower_right_quarter")
            private LeftEyeLowerRightQuarterBean leftEyeLowerRightQuarter;
            @SerializedName("nose_contour_right1")
            private NoseContourRight1Bean noseContourRight1;
            @SerializedName("contour_right9")
            private ContourRight9Bean contourRight9;
            @SerializedName("right_eye_left_corner")
            private RightEyeLeftCornerBean rightEyeLeftCorner;
            @SerializedName("left_eyebrow_upper_left_quarter")
            private LeftEyebrowUpperLeftQuarterBean leftEyebrowUpperLeftQuarter;
            @SerializedName("left_eye_pupil")
            private LeftEyePupilBean leftEyePupil;
            @SerializedName("right_eyebrow_upper_left_quarter")
            private RightEyebrowUpperLeftQuarterBean rightEyebrowUpperLeftQuarter;
            @SerializedName("contour_right8")
            private ContourRight8Bean contourRight8;
            @SerializedName("right_eyebrow_right_corner")
            private RightEyebrowRightCornerBean rightEyebrowRightCorner;
            @SerializedName("right_eye_upper_left_quarter")
            private RightEyeUpperLeftQuarterBean rightEyeUpperLeftQuarter;
            @SerializedName("left_eyebrow_upper_middle")
            private LeftEyebrowUpperMiddleBean leftEyebrowUpperMiddle;
            @SerializedName("right_eyebrow_upper_right_quarter")
            private RightEyebrowUpperRightQuarterBean rightEyebrowUpperRightQuarter;
            @SerializedName("nose_contour_left1")
            private NoseContourLeft1Bean noseContourLeft1;
            @SerializedName("nose_contour_left2")
            private NoseContourLeft2Bean noseContourLeft2;
            @SerializedName("mouth_upper_lip_right_contour1")
            private MouthUpperLipRightContour1Bean mouthUpperLipRightContour1;
            @SerializedName("contour_right1")
            private ContourRight1Bean contourRight1;
            @SerializedName("nose_contour_right2")
            private NoseContourRight2Bean noseContourRight2;
            @SerializedName("mouth_lower_lip_right_contour2")
            private MouthLowerLipRightContour2Bean mouthLowerLipRightContour2;
            @SerializedName("contour_right6")
            private ContourRight6Bean contourRight6;
            @SerializedName("nose_contour_right3")
            private NoseContourRight3Bean noseContourRight3;
            @SerializedName("nose_contour_left3")
            private NoseContourLeft3Bean noseContourLeft3;
            @SerializedName("left_eye_right_corner")
            private LeftEyeRightCornerBean leftEyeRightCorner;
            @SerializedName("left_eyebrow_upper_right_quarter")
            private LeftEyebrowUpperRightQuarterBean leftEyebrowUpperRightQuarter;
            @SerializedName("right_eye_pupil")
            private RightEyePupilBean rightEyePupil;
            @SerializedName("mouth_upper_lip_bottom")
            private MouthUpperLipBottomBean mouthUpperLipBottom;

            public MouthUpperLipLeftContour2Bean getMouthUpperLipLeftContour2() {
                return mouthUpperLipLeftContour2;
            }

            public void setMouthUpperLipLeftContour2(MouthUpperLipLeftContour2Bean mouthUpperLipLeftContour2) {
                this.mouthUpperLipLeftContour2 = mouthUpperLipLeftContour2;
            }

            public MouthUpperLipLeftContour3Bean getMouthUpperLipLeftContour3() {
                return mouthUpperLipLeftContour3;
            }

            public void setMouthUpperLipLeftContour3(MouthUpperLipLeftContour3Bean mouthUpperLipLeftContour3) {
                this.mouthUpperLipLeftContour3 = mouthUpperLipLeftContour3;
            }

            public MouthLowerLipRightContour3Bean getMouthLowerLipRightContour3() {
                return mouthLowerLipRightContour3;
            }

            public void setMouthLowerLipRightContour3(MouthLowerLipRightContour3Bean mouthLowerLipRightContour3) {
                this.mouthLowerLipRightContour3 = mouthLowerLipRightContour3;
            }

            public MouthUpperLipLeftContour1Bean getMouthUpperLipLeftContour1() {
                return mouthUpperLipLeftContour1;
            }

            public void setMouthUpperLipLeftContour1(MouthUpperLipLeftContour1Bean mouthUpperLipLeftContour1) {
                this.mouthUpperLipLeftContour1 = mouthUpperLipLeftContour1;
            }

            public LeftEyeUpperLeftQuarterBean getLeftEyeUpperLeftQuarter() {
                return leftEyeUpperLeftQuarter;
            }

            public void setLeftEyeUpperLeftQuarter(LeftEyeUpperLeftQuarterBean leftEyeUpperLeftQuarter) {
                this.leftEyeUpperLeftQuarter = leftEyeUpperLeftQuarter;
            }

            public LeftEyebrowLowerMiddleBean getLeftEyebrowLowerMiddle() {
                return leftEyebrowLowerMiddle;
            }

            public void setLeftEyebrowLowerMiddle(LeftEyebrowLowerMiddleBean leftEyebrowLowerMiddle) {
                this.leftEyebrowLowerMiddle = leftEyebrowLowerMiddle;
            }

            public ContourChinBean getContourChin() {
                return contourChin;
            }

            public void setContourChin(ContourChinBean contourChin) {
                this.contourChin = contourChin;
            }

            public LeftEyebrowLowerLeftQuarterBean getLeftEyebrowLowerLeftQuarter() {
                return leftEyebrowLowerLeftQuarter;
            }

            public void setLeftEyebrowLowerLeftQuarter(LeftEyebrowLowerLeftQuarterBean leftEyebrowLowerLeftQuarter) {
                this.leftEyebrowLowerLeftQuarter = leftEyebrowLowerLeftQuarter;
            }

            public RightEyebrowLowerLeftQuarterBean getRightEyebrowLowerLeftQuarter() {
                return rightEyebrowLowerLeftQuarter;
            }

            public void setRightEyebrowLowerLeftQuarter(RightEyebrowLowerLeftQuarterBean rightEyebrowLowerLeftQuarter) {
                this.rightEyebrowLowerLeftQuarter = rightEyebrowLowerLeftQuarter;
            }

            public MouthLowerLipRightContour1Bean getMouthLowerLipRightContour1() {
                return mouthLowerLipRightContour1;
            }

            public void setMouthLowerLipRightContour1(MouthLowerLipRightContour1Bean mouthLowerLipRightContour1) {
                this.mouthLowerLipRightContour1 = mouthLowerLipRightContour1;
            }

            public MouthLowerLipLeftContour2Bean getMouthLowerLipLeftContour2() {
                return mouthLowerLipLeftContour2;
            }

            public void setMouthLowerLipLeftContour2(MouthLowerLipLeftContour2Bean mouthLowerLipLeftContour2) {
                this.mouthLowerLipLeftContour2 = mouthLowerLipLeftContour2;
            }

            public LeftEyeBottomBean getLeftEyeBottom() {
                return leftEyeBottom;
            }

            public void setLeftEyeBottom(LeftEyeBottomBean leftEyeBottom) {
                this.leftEyeBottom = leftEyeBottom;
            }

            public MouthLowerLipBottomBean getMouthLowerLipBottom() {
                return mouthLowerLipBottom;
            }

            public void setMouthLowerLipBottom(MouthLowerLipBottomBean mouthLowerLipBottom) {
                this.mouthLowerLipBottom = mouthLowerLipBottom;
            }

            public ContourLeft9Bean getContourLeft9() {
                return contourLeft9;
            }

            public void setContourLeft9(ContourLeft9Bean contourLeft9) {
                this.contourLeft9 = contourLeft9;
            }

            public MouthLowerLipTopBean getMouthLowerLipTop() {
                return mouthLowerLipTop;
            }

            public void setMouthLowerLipTop(MouthLowerLipTopBean mouthLowerLipTop) {
                this.mouthLowerLipTop = mouthLowerLipTop;
            }

            public RightEyebrowUpperMiddleBean getRightEyebrowUpperMiddle() {
                return rightEyebrowUpperMiddle;
            }

            public void setRightEyebrowUpperMiddle(RightEyebrowUpperMiddleBean rightEyebrowUpperMiddle) {
                this.rightEyebrowUpperMiddle = rightEyebrowUpperMiddle;
            }

            public RightEyebrowLeftCornerBean getRightEyebrowLeftCorner() {
                return rightEyebrowLeftCorner;
            }

            public void setRightEyebrowLeftCorner(RightEyebrowLeftCornerBean rightEyebrowLeftCorner) {
                this.rightEyebrowLeftCorner = rightEyebrowLeftCorner;
            }

            public RightEyeBottomBean getRightEyeBottom() {
                return rightEyeBottom;
            }

            public void setRightEyeBottom(RightEyeBottomBean rightEyeBottom) {
                this.rightEyeBottom = rightEyeBottom;
            }

            public ContourLeft7Bean getContourLeft7() {
                return contourLeft7;
            }

            public void setContourLeft7(ContourLeft7Bean contourLeft7) {
                this.contourLeft7 = contourLeft7;
            }

            public ContourLeft6Bean getContourLeft6() {
                return contourLeft6;
            }

            public void setContourLeft6(ContourLeft6Bean contourLeft6) {
                this.contourLeft6 = contourLeft6;
            }

            public ContourLeft5Bean getContourLeft5() {
                return contourLeft5;
            }

            public void setContourLeft5(ContourLeft5Bean contourLeft5) {
                this.contourLeft5 = contourLeft5;
            }

            public ContourLeft4Bean getContourLeft4() {
                return contourLeft4;
            }

            public void setContourLeft4(ContourLeft4Bean contourLeft4) {
                this.contourLeft4 = contourLeft4;
            }

            public ContourLeft3Bean getContourLeft3() {
                return contourLeft3;
            }

            public void setContourLeft3(ContourLeft3Bean contourLeft3) {
                this.contourLeft3 = contourLeft3;
            }

            public ContourLeft2Bean getContourLeft2() {
                return contourLeft2;
            }

            public void setContourLeft2(ContourLeft2Bean contourLeft2) {
                this.contourLeft2 = contourLeft2;
            }

            public ContourLeft1Bean getContourLeft1() {
                return contourLeft1;
            }

            public void setContourLeft1(ContourLeft1Bean contourLeft1) {
                this.contourLeft1 = contourLeft1;
            }

            public LeftEyeLowerLeftQuarterBean getLeftEyeLowerLeftQuarter() {
                return leftEyeLowerLeftQuarter;
            }

            public void setLeftEyeLowerLeftQuarter(LeftEyeLowerLeftQuarterBean leftEyeLowerLeftQuarter) {
                this.leftEyeLowerLeftQuarter = leftEyeLowerLeftQuarter;
            }

            public MouthUpperLipTopBean getMouthUpperLipTop() {
                return mouthUpperLipTop;
            }

            public void setMouthUpperLipTop(MouthUpperLipTopBean mouthUpperLipTop) {
                this.mouthUpperLipTop = mouthUpperLipTop;
            }

            public ContourRight3Bean getContourRight3() {
                return contourRight3;
            }

            public void setContourRight3(ContourRight3Bean contourRight3) {
                this.contourRight3 = contourRight3;
            }

            public ContourRight2Bean getContourRight2() {
                return contourRight2;
            }

            public void setContourRight2(ContourRight2Bean contourRight2) {
                this.contourRight2 = contourRight2;
            }

            public MouthLeftCornerBean getMouthLeftCorner() {
                return mouthLeftCorner;
            }

            public void setMouthLeftCorner(MouthLeftCornerBean mouthLeftCorner) {
                this.mouthLeftCorner = mouthLeftCorner;
            }

            public ContourRight4Bean getContourRight4() {
                return contourRight4;
            }

            public void setContourRight4(ContourRight4Bean contourRight4) {
                this.contourRight4 = contourRight4;
            }

            public ContourRight7Bean getContourRight7() {
                return contourRight7;
            }

            public void setContourRight7(ContourRight7Bean contourRight7) {
                this.contourRight7 = contourRight7;
            }

            public LeftEyebrowLeftCornerBean getLeftEyebrowLeftCorner() {
                return leftEyebrowLeftCorner;
            }

            public void setLeftEyebrowLeftCorner(LeftEyebrowLeftCornerBean leftEyebrowLeftCorner) {
                this.leftEyebrowLeftCorner = leftEyebrowLeftCorner;
            }

            public NoseRightBean getNoseRight() {
                return noseRight;
            }

            public void setNoseRight(NoseRightBean noseRight) {
                this.noseRight = noseRight;
            }

            public RightEyeUpperRightQuarterBean getRightEyeUpperRightQuarter() {
                return rightEyeUpperRightQuarter;
            }

            public void setRightEyeUpperRightQuarter(RightEyeUpperRightQuarterBean rightEyeUpperRightQuarter) {
                this.rightEyeUpperRightQuarter = rightEyeUpperRightQuarter;
            }

            public NoseTipBean getNoseTip() {
                return noseTip;
            }

            public void setNoseTip(NoseTipBean noseTip) {
                this.noseTip = noseTip;
            }

            public ContourRight5Bean getContourRight5() {
                return contourRight5;
            }

            public void setContourRight5(ContourRight5Bean contourRight5) {
                this.contourRight5 = contourRight5;
            }

            public NoseContourLowerMiddleBean getNoseContourLowerMiddle() {
                return noseContourLowerMiddle;
            }

            public void setNoseContourLowerMiddle(NoseContourLowerMiddleBean noseContourLowerMiddle) {
                this.noseContourLowerMiddle = noseContourLowerMiddle;
            }

            public RightEyeTopBean getRightEyeTop() {
                return rightEyeTop;
            }

            public void setRightEyeTop(RightEyeTopBean rightEyeTop) {
                this.rightEyeTop = rightEyeTop;
            }

            public MouthLowerLipLeftContour3Bean getMouthLowerLipLeftContour3() {
                return mouthLowerLipLeftContour3;
            }

            public void setMouthLowerLipLeftContour3(MouthLowerLipLeftContour3Bean mouthLowerLipLeftContour3) {
                this.mouthLowerLipLeftContour3 = mouthLowerLipLeftContour3;
            }

            public RightEyeRightCornerBean getRightEyeRightCorner() {
                return rightEyeRightCorner;
            }

            public void setRightEyeRightCorner(RightEyeRightCornerBean rightEyeRightCorner) {
                this.rightEyeRightCorner = rightEyeRightCorner;
            }

            public RightEyeLowerRightQuarterBean getRightEyeLowerRightQuarter() {
                return rightEyeLowerRightQuarter;
            }

            public void setRightEyeLowerRightQuarter(RightEyeLowerRightQuarterBean rightEyeLowerRightQuarter) {
                this.rightEyeLowerRightQuarter = rightEyeLowerRightQuarter;
            }

            public MouthUpperLipRightContour2Bean getMouthUpperLipRightContour2() {
                return mouthUpperLipRightContour2;
            }

            public void setMouthUpperLipRightContour2(MouthUpperLipRightContour2Bean mouthUpperLipRightContour2) {
                this.mouthUpperLipRightContour2 = mouthUpperLipRightContour2;
            }

            public RightEyebrowLowerRightQuarterBean getRightEyebrowLowerRightQuarter() {
                return rightEyebrowLowerRightQuarter;
            }

            public void setRightEyebrowLowerRightQuarter(RightEyebrowLowerRightQuarterBean rightEyebrowLowerRightQuarter) {
                this.rightEyebrowLowerRightQuarter = rightEyebrowLowerRightQuarter;
            }

            public LeftEyeLeftCornerBean getLeftEyeLeftCorner() {
                return leftEyeLeftCorner;
            }

            public void setLeftEyeLeftCorner(LeftEyeLeftCornerBean leftEyeLeftCorner) {
                this.leftEyeLeftCorner = leftEyeLeftCorner;
            }

            public MouthRightCornerBean getMouthRightCorner() {
                return mouthRightCorner;
            }

            public void setMouthRightCorner(MouthRightCornerBean mouthRightCorner) {
                this.mouthRightCorner = mouthRightCorner;
            }

            public MouthUpperLipRightContour3Bean getMouthUpperLipRightContour3() {
                return mouthUpperLipRightContour3;
            }

            public void setMouthUpperLipRightContour3(MouthUpperLipRightContour3Bean mouthUpperLipRightContour3) {
                this.mouthUpperLipRightContour3 = mouthUpperLipRightContour3;
            }

            public RightEyeLowerLeftQuarterBean getRightEyeLowerLeftQuarter() {
                return rightEyeLowerLeftQuarter;
            }

            public void setRightEyeLowerLeftQuarter(RightEyeLowerLeftQuarterBean rightEyeLowerLeftQuarter) {
                this.rightEyeLowerLeftQuarter = rightEyeLowerLeftQuarter;
            }

            public LeftEyebrowRightCornerBean getLeftEyebrowRightCorner() {
                return leftEyebrowRightCorner;
            }

            public void setLeftEyebrowRightCorner(LeftEyebrowRightCornerBean leftEyebrowRightCorner) {
                this.leftEyebrowRightCorner = leftEyebrowRightCorner;
            }

            public LeftEyebrowLowerRightQuarterBean getLeftEyebrowLowerRightQuarter() {
                return leftEyebrowLowerRightQuarter;
            }

            public void setLeftEyebrowLowerRightQuarter(LeftEyebrowLowerRightQuarterBean leftEyebrowLowerRightQuarter) {
                this.leftEyebrowLowerRightQuarter = leftEyebrowLowerRightQuarter;
            }

            public RightEyeCenterBean getRightEyeCenter() {
                return rightEyeCenter;
            }

            public void setRightEyeCenter(RightEyeCenterBean rightEyeCenter) {
                this.rightEyeCenter = rightEyeCenter;
            }

            public LeftEyeUpperRightQuarterBean getLeftEyeUpperRightQuarter() {
                return leftEyeUpperRightQuarter;
            }

            public void setLeftEyeUpperRightQuarter(LeftEyeUpperRightQuarterBean leftEyeUpperRightQuarter) {
                this.leftEyeUpperRightQuarter = leftEyeUpperRightQuarter;
            }

            public MouthLowerLipLeftContour1Bean getMouthLowerLipLeftContour1() {
                return mouthLowerLipLeftContour1;
            }

            public void setMouthLowerLipLeftContour1(MouthLowerLipLeftContour1Bean mouthLowerLipLeftContour1) {
                this.mouthLowerLipLeftContour1 = mouthLowerLipLeftContour1;
            }

            public ContourLeft8Bean getContourLeft8() {
                return contourLeft8;
            }

            public void setContourLeft8(ContourLeft8Bean contourLeft8) {
                this.contourLeft8 = contourLeft8;
            }

            public NoseLeftBean getNoseLeft() {
                return noseLeft;
            }

            public void setNoseLeft(NoseLeftBean noseLeft) {
                this.noseLeft = noseLeft;
            }

            public RightEyebrowLowerMiddleBean getRightEyebrowLowerMiddle() {
                return rightEyebrowLowerMiddle;
            }

            public void setRightEyebrowLowerMiddle(RightEyebrowLowerMiddleBean rightEyebrowLowerMiddle) {
                this.rightEyebrowLowerMiddle = rightEyebrowLowerMiddle;
            }

            public LeftEyeTopBean getLeftEyeTop() {
                return leftEyeTop;
            }

            public void setLeftEyeTop(LeftEyeTopBean leftEyeTop) {
                this.leftEyeTop = leftEyeTop;
            }

            public LeftEyeCenterBean getLeftEyeCenter() {
                return leftEyeCenter;
            }

            public void setLeftEyeCenter(LeftEyeCenterBean leftEyeCenter) {
                this.leftEyeCenter = leftEyeCenter;
            }

            public LeftEyeLowerRightQuarterBean getLeftEyeLowerRightQuarter() {
                return leftEyeLowerRightQuarter;
            }

            public void setLeftEyeLowerRightQuarter(LeftEyeLowerRightQuarterBean leftEyeLowerRightQuarter) {
                this.leftEyeLowerRightQuarter = leftEyeLowerRightQuarter;
            }

            public NoseContourRight1Bean getNoseContourRight1() {
                return noseContourRight1;
            }

            public void setNoseContourRight1(NoseContourRight1Bean noseContourRight1) {
                this.noseContourRight1 = noseContourRight1;
            }

            public ContourRight9Bean getContourRight9() {
                return contourRight9;
            }

            public void setContourRight9(ContourRight9Bean contourRight9) {
                this.contourRight9 = contourRight9;
            }

            public RightEyeLeftCornerBean getRightEyeLeftCorner() {
                return rightEyeLeftCorner;
            }

            public void setRightEyeLeftCorner(RightEyeLeftCornerBean rightEyeLeftCorner) {
                this.rightEyeLeftCorner = rightEyeLeftCorner;
            }

            public LeftEyebrowUpperLeftQuarterBean getLeftEyebrowUpperLeftQuarter() {
                return leftEyebrowUpperLeftQuarter;
            }

            public void setLeftEyebrowUpperLeftQuarter(LeftEyebrowUpperLeftQuarterBean leftEyebrowUpperLeftQuarter) {
                this.leftEyebrowUpperLeftQuarter = leftEyebrowUpperLeftQuarter;
            }

            public LeftEyePupilBean getLeftEyePupil() {
                return leftEyePupil;
            }

            public void setLeftEyePupil(LeftEyePupilBean leftEyePupil) {
                this.leftEyePupil = leftEyePupil;
            }

            public RightEyebrowUpperLeftQuarterBean getRightEyebrowUpperLeftQuarter() {
                return rightEyebrowUpperLeftQuarter;
            }

            public void setRightEyebrowUpperLeftQuarter(RightEyebrowUpperLeftQuarterBean rightEyebrowUpperLeftQuarter) {
                this.rightEyebrowUpperLeftQuarter = rightEyebrowUpperLeftQuarter;
            }

            public ContourRight8Bean getContourRight8() {
                return contourRight8;
            }

            public void setContourRight8(ContourRight8Bean contourRight8) {
                this.contourRight8 = contourRight8;
            }

            public RightEyebrowRightCornerBean getRightEyebrowRightCorner() {
                return rightEyebrowRightCorner;
            }

            public void setRightEyebrowRightCorner(RightEyebrowRightCornerBean rightEyebrowRightCorner) {
                this.rightEyebrowRightCorner = rightEyebrowRightCorner;
            }

            public RightEyeUpperLeftQuarterBean getRightEyeUpperLeftQuarter() {
                return rightEyeUpperLeftQuarter;
            }

            public void setRightEyeUpperLeftQuarter(RightEyeUpperLeftQuarterBean rightEyeUpperLeftQuarter) {
                this.rightEyeUpperLeftQuarter = rightEyeUpperLeftQuarter;
            }

            public LeftEyebrowUpperMiddleBean getLeftEyebrowUpperMiddle() {
                return leftEyebrowUpperMiddle;
            }

            public void setLeftEyebrowUpperMiddle(LeftEyebrowUpperMiddleBean leftEyebrowUpperMiddle) {
                this.leftEyebrowUpperMiddle = leftEyebrowUpperMiddle;
            }

            public RightEyebrowUpperRightQuarterBean getRightEyebrowUpperRightQuarter() {
                return rightEyebrowUpperRightQuarter;
            }

            public void setRightEyebrowUpperRightQuarter(RightEyebrowUpperRightQuarterBean rightEyebrowUpperRightQuarter) {
                this.rightEyebrowUpperRightQuarter = rightEyebrowUpperRightQuarter;
            }

            public NoseContourLeft1Bean getNoseContourLeft1() {
                return noseContourLeft1;
            }

            public void setNoseContourLeft1(NoseContourLeft1Bean noseContourLeft1) {
                this.noseContourLeft1 = noseContourLeft1;
            }

            public NoseContourLeft2Bean getNoseContourLeft2() {
                return noseContourLeft2;
            }

            public void setNoseContourLeft2(NoseContourLeft2Bean noseContourLeft2) {
                this.noseContourLeft2 = noseContourLeft2;
            }

            public MouthUpperLipRightContour1Bean getMouthUpperLipRightContour1() {
                return mouthUpperLipRightContour1;
            }

            public void setMouthUpperLipRightContour1(MouthUpperLipRightContour1Bean mouthUpperLipRightContour1) {
                this.mouthUpperLipRightContour1 = mouthUpperLipRightContour1;
            }

            public ContourRight1Bean getContourRight1() {
                return contourRight1;
            }

            public void setContourRight1(ContourRight1Bean contourRight1) {
                this.contourRight1 = contourRight1;
            }

            public NoseContourRight2Bean getNoseContourRight2() {
                return noseContourRight2;
            }

            public void setNoseContourRight2(NoseContourRight2Bean noseContourRight2) {
                this.noseContourRight2 = noseContourRight2;
            }

            public MouthLowerLipRightContour2Bean getMouthLowerLipRightContour2() {
                return mouthLowerLipRightContour2;
            }

            public void setMouthLowerLipRightContour2(MouthLowerLipRightContour2Bean mouthLowerLipRightContour2) {
                this.mouthLowerLipRightContour2 = mouthLowerLipRightContour2;
            }

            public ContourRight6Bean getContourRight6() {
                return contourRight6;
            }

            public void setContourRight6(ContourRight6Bean contourRight6) {
                this.contourRight6 = contourRight6;
            }

            public NoseContourRight3Bean getNoseContourRight3() {
                return noseContourRight3;
            }

            public void setNoseContourRight3(NoseContourRight3Bean noseContourRight3) {
                this.noseContourRight3 = noseContourRight3;
            }

            public NoseContourLeft3Bean getNoseContourLeft3() {
                return noseContourLeft3;
            }

            public void setNoseContourLeft3(NoseContourLeft3Bean noseContourLeft3) {
                this.noseContourLeft3 = noseContourLeft3;
            }

            public LeftEyeRightCornerBean getLeftEyeRightCorner() {
                return leftEyeRightCorner;
            }

            public void setLeftEyeRightCorner(LeftEyeRightCornerBean leftEyeRightCorner) {
                this.leftEyeRightCorner = leftEyeRightCorner;
            }

            public LeftEyebrowUpperRightQuarterBean getLeftEyebrowUpperRightQuarter() {
                return leftEyebrowUpperRightQuarter;
            }

            public void setLeftEyebrowUpperRightQuarter(LeftEyebrowUpperRightQuarterBean leftEyebrowUpperRightQuarter) {
                this.leftEyebrowUpperRightQuarter = leftEyebrowUpperRightQuarter;
            }

            public RightEyePupilBean getRightEyePupil() {
                return rightEyePupil;
            }

            public void setRightEyePupil(RightEyePupilBean rightEyePupil) {
                this.rightEyePupil = rightEyePupil;
            }

            public MouthUpperLipBottomBean getMouthUpperLipBottom() {
                return mouthUpperLipBottom;
            }

            public void setMouthUpperLipBottom(MouthUpperLipBottomBean mouthUpperLipBottom) {
                this.mouthUpperLipBottom = mouthUpperLipBottom;
            }

            public static class MouthUpperLipLeftContour2Bean {
                /**
                 * y : 493
                 * x : 490
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class MouthUpperLipLeftContour3Bean {
                /**
                 * y : 499
                 * x : 498
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class MouthLowerLipRightContour3Bean {
                /**
                 * y : 512
                 * x : 555
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class MouthUpperLipLeftContour1Bean {
                /**
                 * y : 490
                 * x : 514
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class LeftEyeUpperLeftQuarterBean {
                /**
                 * y : 318
                 * x : 433
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class LeftEyebrowLowerMiddleBean {
                /**
                 * y : 308
                 * x : 434
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class ContourChinBean {
                /**
                 * y : 605
                 * x : 533
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class LeftEyebrowLowerLeftQuarterBean {
                /**
                 * y : 305
                 * x : 411
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class RightEyebrowLowerLeftQuarterBean {
                /**
                 * y : 310
                 * x : 584
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class MouthLowerLipRightContour1Bean {
                /**
                 * y : 498
                 * x : 561
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class MouthLowerLipLeftContour2Bean {
                /**
                 * y : 508
                 * x : 485
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class LeftEyeBottomBean {
                /**
                 * y : 336
                 * x : 447
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class MouthLowerLipBottomBean {
                /**
                 * y : 516
                 * x : 530
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class ContourLeft9Bean {
                /**
                 * y : 597
                 * x : 490
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class MouthLowerLipTopBean {
                /**
                 * y : 503
                 * x : 529
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class RightEyebrowUpperMiddleBean {
                /**
                 * y : 294
                 * x : 607
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class RightEyebrowLeftCornerBean {
                /**
                 * y : 309
                 * x : 561
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class RightEyeBottomBean {
                /**
                 * y : 335
                 * x : 594
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class ContourLeft7Bean {
                /**
                 * y : 547
                 * x : 431
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class ContourLeft6Bean {
                /**
                 * y : 515
                 * x : 409
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class ContourLeft5Bean {
                /**
                 * y : 480
                 * x : 394
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class ContourLeft4Bean {
                /**
                 * y : 442
                 * x : 384
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class ContourLeft3Bean {
                /**
                 * y : 404
                 * x : 378
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class ContourLeft2Bean {
                /**
                 * y : 366
                 * x : 373
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class ContourLeft1Bean {
                /**
                 * y : 327
                 * x : 370
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class LeftEyeLowerLeftQuarterBean {
                /**
                 * y : 332
                 * x : 431
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class MouthUpperLipTopBean {
                /**
                 * y : 492
                 * x : 528
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class ContourRight3Bean {
                /**
                 * y : 402
                 * x : 686
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class ContourRight2Bean {
                /**
                 * y : 364
                 * x : 689
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class MouthLeftCornerBean {
                /**
                 * y : 497
                 * x : 467
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class ContourRight4Bean {
                /**
                 * y : 441
                 * x : 681
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class ContourRight7Bean {
                /**
                 * y : 545
                 * x : 636
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class LeftEyebrowLeftCornerBean {
                /**
                 * y : 303
                 * x : 390
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class NoseRightBean {
                /**
                 * y : 435
                 * x : 570
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class RightEyeUpperRightQuarterBean {
                /**
                 * y : 319
                 * x : 608
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class NoseTipBean {
                /**
                 * y : 443
                 * x : 523
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class ContourRight5Bean {
                /**
                 * y : 478
                 * x : 672
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class NoseContourLowerMiddleBean {
                /**
                 * y : 462
                 * x : 526
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class RightEyeTopBean {
                /**
                 * y : 316
                 * x : 593
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class MouthLowerLipLeftContour3Bean {
                /**
                 * y : 515
                 * x : 506
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class RightEyeRightCornerBean {
                /**
                 * y : 328
                 * x : 621
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class RightEyeLowerRightQuarterBean {
                /**
                 * y : 333
                 * x : 608
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class MouthUpperLipRightContour2Bean {
                /**
                 * y : 488
                 * x : 567
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class RightEyebrowLowerRightQuarterBean {
                /**
                 * y : 310
                 * x : 628
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class LeftEyeLeftCornerBean {
                /**
                 * y : 325
                 * x : 419
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class MouthRightCornerBean {
                /**
                 * y : 489
                 * x : 593
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class MouthUpperLipRightContour3Bean {
                /**
                 * y : 495
                 * x : 561
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class RightEyeLowerLeftQuarterBean {
                /**
                 * y : 333
                 * x : 579
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class LeftEyebrowRightCornerBean {
                /**
                 * y : 316
                 * x : 483
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class LeftEyebrowLowerRightQuarterBean {
                /**
                 * y : 313
                 * x : 458
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class RightEyeCenterBean {
                /**
                 * y : 328
                 * x : 593
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class LeftEyeUpperRightQuarterBean {
                /**
                 * y : 320
                 * x : 464
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class MouthLowerLipLeftContour1Bean {
                /**
                 * y : 502
                 * x : 498
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class ContourLeft8Bean {
                /**
                 * y : 575
                 * x : 457
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class NoseLeftBean {
                /**
                 * y : 439
                 * x : 482
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class RightEyebrowLowerMiddleBean {
                /**
                 * y : 308
                 * x : 607
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class LeftEyeTopBean {
                /**
                 * y : 316
                 * x : 448
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class LeftEyeCenterBean {
                /**
                 * y : 327
                 * x : 448
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class LeftEyeLowerRightQuarterBean {
                /**
                 * y : 334
                 * x : 463
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class NoseContourRight1Bean {
                /**
                 * y : 331
                 * x : 545
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class ContourRight9Bean {
                /**
                 * y : 596
                 * x : 576
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class RightEyeLeftCornerBean {
                /**
                 * y : 331
                 * x : 566
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class LeftEyebrowUpperLeftQuarterBean {
                /**
                 * y : 290
                 * x : 412
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class LeftEyePupilBean {
                /**
                 * y : 325
                 * x : 449
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class RightEyebrowUpperLeftQuarterBean {
                /**
                 * y : 297
                 * x : 583
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class ContourRight8Bean {
                /**
                 * y : 573
                 * x : 609
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class RightEyebrowRightCornerBean {
                /**
                 * y : 313
                 * x : 648
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class RightEyeUpperLeftQuarterBean {
                /**
                 * y : 320
                 * x : 578
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class LeftEyebrowUpperMiddleBean {
                /**
                 * y : 293
                 * x : 437
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class RightEyebrowUpperRightQuarterBean {
                /**
                 * y : 297
                 * x : 630
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class NoseContourLeft1Bean {
                /**
                 * y : 333
                 * x : 500
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class NoseContourLeft2Bean {
                /**
                 * y : 412
                 * x : 491
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class MouthUpperLipRightContour1Bean {
                /**
                 * y : 488
                 * x : 542
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class ContourRight1Bean {
                /**
                 * y : 324
                 * x : 689
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class NoseContourRight2Bean {
                /**
                 * y : 409
                 * x : 559
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class MouthLowerLipRightContour2Bean {
                /**
                 * y : 502
                 * x : 575
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class ContourRight6Bean {
                /**
                 * y : 514
                 * x : 657
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class NoseContourRight3Bean {
                /**
                 * y : 451
                 * x : 550
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class NoseContourLeft3Bean {
                /**
                 * y : 453
                 * x : 502
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class LeftEyeRightCornerBean {
                /**
                 * y : 331
                 * x : 478
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class LeftEyebrowUpperRightQuarterBean {
                /**
                 * y : 301
                 * x : 460
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class RightEyePupilBean {
                /**
                 * y : 324
                 * x : 593
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }

            public static class MouthUpperLipBottomBean {
                /**
                 * y : 500
                 * x : 529
                 */

                @SerializedName("y")
                private int y;
                @SerializedName("x")
                private int x;

                public int getY() {
                    return y;
                }

                public void setY(int y) {
                    this.y = y;
                }

                public int getX() {
                    return x;
                }

                public void setX(int x) {
                    this.x = x;
                }
            }
        }

        public static class FaceRectangleBean {
            /**
             * width : 336
             * top : 287
             * left : 362
             * height : 336
             */

            @SerializedName("width")
            private int width;
            @SerializedName("top")
            private int top;
            @SerializedName("left")
            private int left;
            @SerializedName("height")
            private int height;

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getTop() {
                return top;
            }

            public void setTop(int top) {
                this.top = top;
            }

            public int getLeft() {
                return left;
            }

            public void setLeft(int left) {
                this.left = left;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            @Override
            public String toString() {
                return "FaceRectangleBean{" +
                        "width=" + width +
                        ", top=" + top +
                        ", left=" + left +
                        ", height=" + height +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "FacesBean{" +
                    "landmark=" + landmark +
                    ", faceRectangle=" + faceRectangle +
                    ", faceToken='" + faceToken + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "FaceModel{" +
                "imageId='" + imageId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", timeUsed=" + timeUsed +
                ", faces=" + faces +
                '}';
    }
}
